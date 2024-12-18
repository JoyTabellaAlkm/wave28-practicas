package com.mercadolibre.sprint1.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mercadolibre.sprint1.entity.User;
import com.mercadolibre.sprint1.repository.IRepository;
import com.mercadolibre.sprint1.utils.CResourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IRepository<User> {

	private List<User> users = new ArrayList<>();

	public UserRepositoryImpl() {
		loadData();
	}

	private void loadData() {
		try{
			File file = ResourceUtils.getFile("classpath:user.json");
			users = CResourceUtils.MAPPER.readValue(file, new TypeReference<>(){});
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> findAll() {
		return users;
	}

	@Override
	public User save(User entity) {
		users.add(entity);
		return entity;
	}

	@Override
	public boolean delete(int id) {
		Optional<User> entity = users.stream()
				.filter(p -> p.getId() == id)
				.findFirst();

		if (entity.isEmpty()) {
			return false;
		}

		return delete(entity.get());
	}

	@Override
	public boolean delete(User entity) {
		return users.remove(entity);
	}

}
