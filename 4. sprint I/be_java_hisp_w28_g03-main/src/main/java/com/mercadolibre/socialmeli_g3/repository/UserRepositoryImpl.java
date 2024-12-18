package com.mercadolibre.socialmeli_g3.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.socialmeli_g3.dto.FollowedListDTO;
import com.mercadolibre.socialmeli_g3.dto.UserDTO;
import com.mercadolibre.socialmeli_g3.entity.Post;
import com.mercadolibre.socialmeli_g3.entity.User;
import com.mercadolibre.socialmeli_g3.exception.NotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserRepository{

    private List<User> usersList;

    public UserRepositoryImpl() throws IOException {
        usersList=new ArrayList<>();
        loadDataBase();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users ;
        file= ResourceUtils.getFile("classpath:usersDb.json");
        users= objectMapper.readValue(file,new TypeReference<List<User>>(){});
        usersList = users;
    }

    @Override
    public User findUserById(int userId) {
        return usersList.stream()
                .filter(userData -> userData.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> findFollowersOrderedByName(int id, String order){

        List<User> listFilter= findUserById(id).getFollowers();
        if( order.equalsIgnoreCase("name_asc")){
            listFilter = listFilter.stream().sorted((Comparator.comparing(User::getUserId))).toList();
        }
         else if( order.equalsIgnoreCase("name_desc")){
            listFilter = listFilter.stream().sorted((Comparator.comparing(User::getUserId)).reversed()).toList();
        }
        return listFilter ;
    }

    @Override
    public List<User> findFollowedOrderedByName(int id, String order){
        List<User> listFilter= findUserById(id).getFollowed();
        if( order.equalsIgnoreCase("name_asc")){
            listFilter = listFilter.stream().sorted((Comparator.comparing(User::getUserId))).toList();
        }
        else if( order.equalsIgnoreCase("name_desc")){
            listFilter = listFilter.stream().sorted((Comparator.comparing(User::getUserId)).reversed()).toList();
        }
        return listFilter ;
    }

    @Override
    public User getFollowers(int userId) {
        return findUserById(userId);
    }

    @Override
    public void unfollow(User user, User userToUnfollow) {
        user.getFollowed().remove(userToUnfollow);
        userToUnfollow.getFollowers().remove(user);
    }

    @Override
    public User follow(User user, User userToFollow) {
        user.getFollowed().add(userToFollow);
        userToFollow.getFollowers().add(user);

        return user;
    }

    @Override
    public List<User> findAllUsers() {

        return usersList;
    }



}
