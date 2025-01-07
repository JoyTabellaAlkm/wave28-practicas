package com.mercadolibre.sprint1.service.impl;

import com.mercadolibre.sprint1.dto.response.FollowersCountDto;
import com.mercadolibre.sprint1.dto.response.UnfollowResponseDto;
import com.mercadolibre.sprint1.entity.UserFollower;
import com.mercadolibre.sprint1.exception.BadRequestException;
import com.mercadolibre.sprint1.exception.NotFoundException;
import com.mercadolibre.sprint1.repository.impl.UserFollowerRepositoryImpl;
import com.mercadolibre.sprint1.repository.impl.UserRepositoryImpl;
import com.mercadolibre.sprint1.service.IUserFollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserFollowerServiceImpl implements IUserFollowerService {

    @Autowired
    private UserFollowerRepositoryImpl userFollowerRepository;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Override
    public UnfollowResponseDto unfollow(int userId, int sellerId) {
        Optional<UserFollower> optionalUserFollower = userFollowerRepository.findByFollowerIdAndFollowedId(userId,sellerId);
        if(optionalUserFollower.isEmpty()){
            throw new NotFoundException("No estas siguiendo al usuario "+sellerId);
        }
        userFollowerRepository.delete(optionalUserFollower.get());
        return new UnfollowResponseDto("Se ha dejado de seguir al usuario "+sellerId);
    }

    @Override
    public FollowersCountDto followersCount(int userId) {
        if(userRepository.findAll().stream().filter(user -> user.getId() == userId).toList().size() != 0) {
            return new FollowersCountDto(
                    userId,
                    userRepository.findAll().stream().filter(user -> user.getId() == userId).findFirst().get().getName(),
                    userFollowerRepository.findAll().stream().filter(user -> user.getUserFollowed() == userId).toList().size()
            );
        }else {
            throw new BadRequestException("Ha ocurrido un error");
        }
    }
}
