package com.mercadolibre.sprint1.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.sprint1.dto.ProductDto;
import com.mercadolibre.sprint1.dto.UserDto;
import com.mercadolibre.sprint1.dto.response.FollowedListByUserDto;
import com.mercadolibre.sprint1.dto.response.FollowersListByUserDto;
import com.mercadolibre.sprint1.dto.response.MostFollowedUserDto;
import com.mercadolibre.sprint1.dto.response.UserPromosAverageDto;
import com.mercadolibre.sprint1.dto.util.MostFollowersPostDto;
import com.mercadolibre.sprint1.entity.Post;
import com.mercadolibre.sprint1.entity.User;
import com.mercadolibre.sprint1.entity.UserFollower;
import com.mercadolibre.sprint1.exception.BadRequestException;
import com.mercadolibre.sprint1.exception.NoContentException;
import com.mercadolibre.sprint1.exception.NotFoundException;
import com.mercadolibre.sprint1.exception.PromoSellersNotFoundException;
import com.mercadolibre.sprint1.repository.IRepository;
import com.mercadolibre.sprint1.repository.impl.UserFollowerRepositoryImpl;
import com.mercadolibre.sprint1.repository.impl.UserRepositoryImpl;
import com.mercadolibre.sprint1.service.IUserService;
import com.mercadolibre.sprint1.utils.Order;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @Autowired
    private IRepository<Post> postRepository;

    @Autowired
    private UserFollowerRepositoryImpl userFollowerRepositoryImpl;

    @Override
    public FollowersListByUserDto findAllFollowersByUser(int userId, String order) {
        User user = findUserById(userId);
        List<UserDto> followers = userFollowerRepositoryImpl.findAll()
                .stream()
                .filter(f -> f.getUserFollowed() == userId)
                .map(f -> findUserById(f.getUserFollower()))
                .map(u -> new UserDto(u.getId(), u.getName()))
                .toList();
        if (order != null) {
            followers = orderUserDtoList(followers, order);
        }
        FollowersListByUserDto res = new FollowersListByUserDto();
        res.setId(user.getId());
        res.setName(user.getName());
        res.setFollowers(followers);
        return res;
    }

    @Override
    public boolean followUser(int userId, int userIdToFollow) {
        User findUser = findUserById(userId);
        User findSeller = findUserById(userIdToFollow);
        if (findSeller.isSeller()) {
            UserFollower userFollower = new UserFollower();
            userFollower.setUserFollowed(userIdToFollow);
            userFollower.setUserFollower(findUser.getId());
            userFollowerRepositoryImpl.save(userFollower);
            return true;
        }
        throw new BadRequestException("El usuario " + userIdToFollow + " no es un vendedor.");
    }

    @Override
    public FollowedListByUserDto findUsersFollowedByUser(int id, String order) {
        User user = findUserById(id);
        List<UserDto> followed = userFollowerRepositoryImpl.findAll()
                .stream()
                .filter(f -> f.getUserFollower() == id)
                .map(f -> findUserById(f.getUserFollowed()))
                .map(u -> new UserDto(u.getId(), u.getName()))
                .toList();
        if (order != null) {
            followed = orderUserDtoList(followed, order);
        }
        FollowedListByUserDto res = new FollowedListByUserDto();
        res.setId(user.getId());
        res.setName(user.getName());
        res.setFollowed(followed);

        return res;
    }

    @Override
    public User findUserById(int userId) {
        return userRepositoryImpl.findAll()
                .stream()
                .filter(u -> u.getId() == userId)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("No existe el usuario " + userId));
    }

    @Override
    public List<UserPromosAverageDto> findUserPromoAverage() {
        Map<Integer, UserPromosAverageDto> promosAverages = new HashMap<>();
        List<Post> posts = postRepository.findAll();
        if (posts.isEmpty())
            throw new PromoSellersNotFoundException("No se encontraron vendedores con promociones activas");
        for (Post post : posts) {
            if (post.getDiscount() <= 0)
                continue;
            try {
                User user = findUserById(post.getUserId());
                UserPromosAverageDto userPromoDto = promosAverages.get(post.getUserId());
                if (userPromoDto == null) {
                    promosAverages.put(post.getUserId(),
                            new UserPromosAverageDto(user.getId(), user.getName(), post.getDiscount(), 1));
                } else {
                    userPromoDto.setPromoAverage(userPromoDto.getPromoAverage() + post.getDiscount());
                    userPromoDto.setCantPost(userPromoDto.getCantPost() + 1);
                }
            } catch (NotFoundException e) {
            }
        }

        if (promosAverages.isEmpty())
            throw new PromoSellersNotFoundException("No se encontraron vendedores con promociones activas");
        List<UserPromosAverageDto> userAveragesData = new ArrayList<>(promosAverages.values());
        for (UserPromosAverageDto uad : userAveragesData) {
            uad.setPromoAverage(uad.getPromoAverage() / uad.getCantPost());
        }
        return userAveragesData;
    }

    @Override
    public MostFollowedUserDto findMostFollowedUser() {

        Map<Integer, Long> followerCounts = userFollowerRepositoryImpl.findAll().stream()
                .collect(Collectors.groupingBy(UserFollower::getUserFollowed, Collectors.counting()));

        int mostFollowedUserId = followerCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new NotFoundException("No se encontró un usuario más seguido"));

        User mostFollowedUser = findUserById(mostFollowedUserId);
        int mostFollowers = followerCounts.get(mostFollowedUserId).intValue();

        List<Post> posts = postRepository.findAll().stream()
                .filter(post -> post.getUserId() == mostFollowedUserId)
                .toList();

        List<MostFollowersPostDto> activePosts = posts.stream()
                .filter(post -> post.getDate().isBefore(LocalDate.now()) || post.getDate().isEqual(LocalDate.now()))
                .map(post -> new MostFollowersPostDto(
                        post.getId(),
                        post.getUserId(),
                        post.getDate(),
                        new ProductDto(post.getProduct().getId(), post.getProduct().getName(),
                                post.getProduct().getType(), post.getProduct().getBrand(), post.getProduct().getColor(),
                                post.getProduct().getNotes()),
                        post.getCategory(),
                        post.getPrice()))
                .collect(Collectors.toList());

        if (activePosts.isEmpty()) {
            throw new NoContentException("El usuario más seguido no tiene publicaciones activas.");
        }

        return new MostFollowedUserDto(mostFollowedUser.getId(), mostFollowedUser.getName(), mostFollowers,
                activePosts);
    }

    private List<UserDto> orderUserDtoList(List<UserDto> userDtoList, String order) {
        if (!(order.equalsIgnoreCase(String.valueOf(Order.NAME_ASC))
                || order.equalsIgnoreCase(String.valueOf(Order.NAME_DESC)))) {
            throw new BadRequestException("El orden requerido no es valido.");
        }

        return userDtoList.stream().sorted((f1, f2) -> {
            if (order.equalsIgnoreCase(String.valueOf(Order.NAME_ASC))) {
                return f1.getName().compareTo(f2.getName());
            }

            return f2.getName().compareTo(f1.getName());
        }).toList();
    }

}
