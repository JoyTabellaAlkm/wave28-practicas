package com.bootcamp.socialmeli.service.impl;

import com.bootcamp.socialmeli.dto.PostDto;
import com.bootcamp.socialmeli.dto.PostPromoDto;
import com.bootcamp.socialmeli.dto.request.PostCreationDto;
import com.bootcamp.socialmeli.exception.IdProductConflictException;
import com.bootcamp.socialmeli.exception.NotFoundException;
import com.bootcamp.socialmeli.util.mapper.PostMapper;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.PostRepository;
import com.bootcamp.socialmeli.repository.ProductRepository;
import com.bootcamp.socialmeli.repository.UserRepository;
import com.bootcamp.socialmeli.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PostRepository postRepo;
    @Autowired
    private ProductRepository productRepo;

    @Override
    public List<PostDto> createPosts(List<PostCreationDto> postsDto) {
        List<Post> posts = new ArrayList<>();
        postsDto.forEach(postDto -> {
            User user = userRepo.findById(postDto.getUser_id())
                    .orElseThrow(() -> new NotFoundException("User", postDto.getUser_id()));
            Post newPost = PostMapper.toPost(postDto);
            productRepo.saveProduct(newPost.getProduct());
            postRepo.save(newPost);
            user.getPosts().add(newPost);
            posts.add(newPost);
        });
        return posts.stream().map(PostMapper::toPostDto).toList();
    }

    @Override
    public List<PostPromoDto> getPosts(Optional<Integer> category) {
        List<Post> posts = postRepo.findAll();
        if (category.isPresent()) {
            if(category.get() < 0 ) throw new IllegalArgumentException("Category must be greater than 0");
            return posts.stream().filter(post ->  post.getCategory().equals(category.get())).map(post -> PostMapper.toPostPromoDto(post)).toList();
        }else {
            return posts.stream().map(post -> PostMapper.toPostPromoDto(post)).toList();
        }
    }
}
