package com.mercadolibre.sprint1.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mercadolibre.sprint1.entity.UserFollower;
import com.mercadolibre.sprint1.repository.IRepository;
import com.mercadolibre.sprint1.utils.CResourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserFollowerRepositoryImpl implements IRepository<UserFollower> {

	private List<UserFollower> usersFollowers = new ArrayList<>();

	public UserFollowerRepositoryImpl() {
		loadData();
	}
	private void loadData() {
		try{
			File file = ResourceUtils.getFile("classpath:userFollower.json");
			usersFollowers = CResourceUtils.MAPPER.readValue(file, new TypeReference<>(){});
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<UserFollower> findAll() {
		return usersFollowers;
	}

	@Override
	public UserFollower save(UserFollower entity){
		usersFollowers.add(entity);
		return entity;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public boolean delete(UserFollower entity) {
		return usersFollowers.remove(entity);
	}

	public Optional<UserFollower> findByFollowerIdAndFollowedId(int userId, int sellerId){
		return usersFollowers.stream().filter(u -> u.getUserFollower() == userId && u.getUserFollowed() == sellerId).findFirst();
	}

}
