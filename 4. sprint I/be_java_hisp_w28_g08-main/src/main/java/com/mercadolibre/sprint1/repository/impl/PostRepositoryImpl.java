package com.mercadolibre.sprint1.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mercadolibre.sprint1.entity.Post;
import com.mercadolibre.sprint1.repository.IRepository;
import com.mercadolibre.sprint1.utils.CResourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements IRepository<Post> {

	private List<Post> posts = new ArrayList<>();

	public PostRepositoryImpl() {
		loadData();
	}

	private void loadData() {
		try {
			File file = ResourceUtils.getFile("classpath:post.json");
			posts = CResourceUtils.MAPPER.readValue(file, new TypeReference<>() {});
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Post> findAll() {
		return posts;
	}

	@Override
	public Post save(Post entity) {
		entity.setId(posts.size()+1);
		posts.add(entity);
		return entity;
	}

	@Override
	public boolean delete(int id) {
		Optional<Post> entity = posts.stream()
				.filter(p -> p.getId() == id)
				.findFirst();

		if (entity.isEmpty()) {
			return false;
		}

		return delete(entity.get());
	}

	@Override
	public boolean delete(Post entity) {
		return posts.remove(entity);
	}
}
