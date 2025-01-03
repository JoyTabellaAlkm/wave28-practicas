package com.mercadolibre.socialmeli_g3.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.socialmeli_g3.dto.response.FollowersCountDTO;
import com.mercadolibre.socialmeli_g3.dto.response.FollowersListDTO;
import com.mercadolibre.socialmeli_g3.dto.response.UserDTO;
import com.mercadolibre.socialmeli_g3.entity.User;
import com.mercadolibre.socialmeli_g3.exception.NotFoundException;
import com.mercadolibre.socialmeli_g3.dto.response.FollowedListDTO;
import com.mercadolibre.socialmeli_g3.dto.response.FollowDTO;
import com.mercadolibre.socialmeli_g3.exception.BadRequestException;
import com.mercadolibre.socialmeli_g3.exception.ConflictException;
import com.mercadolibre.socialmeli_g3.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final ObjectMapper mapper;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
        mapper= new ObjectMapper();
    }


    // CU 004
    @Override
    public FollowedListDTO getFollowedByUserId(int id) {
        User user = validateUserExistence(id);
        FollowedListDTO followedListDTO = new FollowedListDTO();

        List<UserDTO> followedUsersDTOS = user.getFollowed()
                .stream().map(u -> new UserDTO(u.getUserId(), u.getUserName()))
                .toList();
//        @Test manual prueba de error
//        List<UserDTO> followedUsersDTOS= new ArrayList<>();

        if (followedUsersDTOS == null || followedUsersDTOS.isEmpty())  throw new NotFoundException("The user " + user.getUserName() + " does not follow anyone");

        followedListDTO.setUserId(user.getUserId());
        followedListDTO.setUserName(user.getUserName());
        followedListDTO.setFollowed(followedUsersDTOS);
        return followedListDTO;
    }

    // CU 003
    @Override
    public FollowersListDTO getSellerFollowers(int userId) {

        User userFollowers = validateUserExistence(userId);

        List<UserDTO> followersList = userFollowers.getFollowers().stream()
                .map(user -> new UserDTO(user.getUserId(), user.getUserName()))
                .toList();

        return new FollowersListDTO(userFollowers.getUserId(), userFollowers.getUserName(), followersList);
    }

    @Override
    public boolean unfollow(int userId, int userIdToUnfollow) {
        if (userId == userIdToUnfollow) throw new BadRequestException("You cannot unfollow yourself");

        User user = validateUserExistence(userId);
        User userToUnfollow = validateUserExistence(userIdToUnfollow);

        if (!user.getFollowed().contains(userToUnfollow) || !userToUnfollow.getFollowers().contains(user)) {
            throw new NotFoundException("The user is not in the following list");
        }

        userRepository.unfollow(user, userToUnfollow);
        return true;
    }

    @Override
    public FollowDTO follow(int userId, int userIdToFollow) {

        User user = validateUserExistence(userId);
        User userToFollow = validateUserExistence(userIdToFollow);

        if (userId == userIdToFollow) throw new ConflictException("You cant follow yourself");

        if (user.getFollowed().contains(userToFollow) || userToFollow.getFollowers().contains(user)) {
            throw new ConflictException("The user is already in the following list");
        }

        userRepository.follow(user, userToFollow);
        return new FollowDTO(userId, userIdToFollow);
    }

    @Override
    public FollowersCountDTO getNumberFollowers(int userId) {

        User user = validateUserExistence(userId);
        // Obtengo la cantidad de followers
        List<User> followers = user.getFollowers();
        int followersCount = (followers == null) ? 0 : followers.size();

        // mapeo el FollowersCountDTO
        FollowersCountDTO countDTO = new FollowersCountDTO();
        countDTO.setUserId( user.getUserId());
        countDTO.setUserName( user.getUserName());
        countDTO.setFollowersCount(followersCount);

        // Devolver el DTO de followersCountDTO
        return countDTO;
    }

    // CU: 008 - ordenamiento de followers según asc y desc dependiendo el parametro
    @Override
    public FollowersListDTO followersOrderBy(int userId, String order) {
        FollowersListDTO listFilter= new FollowersListDTO();
        // se valida
        validateNameOrderParam(order);
        if(order== null){
            listFilter= getSellerFollowers(userId);
        }
        else if(order.equalsIgnoreCase("name_asc")){
            listFilter= orderFollowersBy(userId,"name_asc");
        }
        else if(order.equalsIgnoreCase("name_desc")){
            listFilter =orderFollowersBy(userId,"name_desc");
        }
       return listFilter;

    }

    @Override
    public FollowedListDTO followedOrderBy(int userId, String order) {
        FollowedListDTO listFilter = new FollowedListDTO();
        validateNameOrderParam(order);
        if(order== null){
            listFilter= getFollowedByUserId(userId);
        }
        else if(order.equalsIgnoreCase("name_asc")){

            listFilter= orderFollowedBy(userId,"name_asc");
        }
       else if(order.equalsIgnoreCase("name_desc")){

            listFilter =orderFollowedBy(userId,"name_desc");
        }

        return listFilter;
    }

    // CU: 008 - ordenamiento de followeds según asc y desc dependiendo el parametro

    private FollowersListDTO orderFollowersBy(int userId, String order) {
        User user = validateUserExistence(userId);

        List<User> listFollowers = userRepository.findFollowersOrderedByName(userId, order);

        List<UserDTO> listOrderFollowers;

        // mapeo la lista
        listOrderFollowers= listFollowers
                .stream()
                .map(v-> new UserDTO(v.getUserId(), v.getUserName()))
                .collect(Collectors.toList());

        // se agrega a FollowersLIstDTO
        FollowersListDTO response= new FollowersListDTO();
        response.setUserId(user.getUserId());
        response.setUserName(user.getUserName());
        response.setFollowers(listOrderFollowers);

        return response;
    }


    private FollowedListDTO orderFollowedBy(int userId, String order) {
        User user = validateUserExistence(userId);

        List<User> listFollowed = userRepository.findFollowedOrderedByName(userId, order);

        List<UserDTO> listOrderFollowed;

        // mapeo la lista
        listOrderFollowed= listFollowed
                .stream()
                .map(v-> new UserDTO(v.getUserId(), v.getUserName()))
                .collect(Collectors.toList());

        // se agrega a FollowersLIstDTO
        FollowedListDTO response= new FollowedListDTO();
        response.setUserId(user.getUserId());
        response.setUserName(user.getUserName());
        response.setFollowed(listOrderFollowed);

        return response;
    }


    public FollowersListDTO getFollowersByUsername(int userId, String username){
        FollowersListDTO followersListByUsernameDTO = new FollowersListDTO();
        User user = validateUserExistence(userId);
        List<UserDTO> followersByUsername = user.getFollowers()
                .stream().filter(u-> u.getUserName().toLowerCase().contains(username.toLowerCase()))
                .map(f-> new UserDTO(f.getUserId(), f.getUserName()))
                .toList();
        if(followersByUsername == null ||  followersByUsername.isEmpty()) throw new NotFoundException("Followers not found");
        followersListByUsernameDTO.setUserId(user.getUserId());
        followersListByUsernameDTO.setUserName(user.getUserName());
        followersListByUsernameDTO.setFollowers(followersByUsername);
        return followersListByUsernameDTO;
    }


    private  void validateNameOrderParam(String order){

        if(order!= null && !order.equalsIgnoreCase("name_asc") && !order.equalsIgnoreCase("name_desc")){
            throw new BadRequestException("The provided filter param is not valid");
        }
    }

    private User validateUserExistence(int userId) {
        User user = userRepository.findUserById(userId);
        if (user== null){
            throw  new NotFoundException("User not found");
        }
        return user;
    }

}
