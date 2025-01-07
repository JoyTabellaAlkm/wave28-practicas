package com.mercadolibre.socialmeli_g3.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.socialmeli_g3.entity.User;
import org.springframework.beans.factory.annotation.Value;
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
    private final String path;

    public UserRepositoryImpl(@Value("${userDB.json.path}") String path) throws IOException {
        usersList=new ArrayList<>();
        this.path = path;
        loadDataBase();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users ;
        file= ResourceUtils.getFile(path);
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
            listFilter = listFilter.stream().sorted((Comparator.comparing(User::getUserName))).toList();
        }
         else if( order.equalsIgnoreCase("name_desc")){
            listFilter = listFilter.stream().sorted((Comparator.comparing(User::getUserName)).reversed()).toList();
        }
        return listFilter ;
    }

    @Override
    public List<User> findFollowedOrderedByName(int id, String order){
        List<User> listFilter= findUserById(id).getFollowed();
        if( order.equalsIgnoreCase("name_asc")){
            listFilter = listFilter.stream().sorted((Comparator.comparing(User::getUserName))).toList();
        }
        else if( order.equalsIgnoreCase("name_desc")){
            listFilter = listFilter.stream().sorted((Comparator.comparing(User::getUserName)).reversed()).toList();
        }
        return listFilter ;
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
