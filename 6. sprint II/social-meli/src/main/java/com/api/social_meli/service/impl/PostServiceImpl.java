package com.api.social_meli.service.impl;

import com.api.social_meli.dto.*;

import com.api.social_meli.exception.BadRequestException;
import com.api.social_meli.exception.NotFoundException;
import com.api.social_meli.model.Post;
import com.api.social_meli.model.PostCategory;
import com.api.social_meli.repository.*;
import com.api.social_meli.repository.IUserRepository;
import com.api.social_meli.service.IPostService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private IPostCategoryRepository postCategoryRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public MessageDto createPost(PostDto dto) {
        Post toRegister = objectMapper.convertValue(dto, Post.class);
        if(!userRepository.exists(dto.getUserId())){
            throw new BadRequestException("Este usuario no existe");
        }
        if(!postCategoryRepository.exists(dto.getCategoryId())){
            throw new BadRequestException("Esta categoria no existe");
        }
        toRegister.setSeller(userRepository.findById(dto.getUserId()));
        toRegister.setPostId(postRepository.findAll().size()+1);
        validatePost(toRegister);
        postRepository.create(toRegister);
        return new MessageDto("Post realizado con exito");
    }

    public PromoPostCountDto getPromoProductCount(Integer userId){
        List<Post> postByUser = postRepository.findAll()
                .stream()
                .filter(p-> p.getSeller().getUserId() == userId && p.isHasPromo())
                .toList();
        if (postByUser.isEmpty())
            throw new NotFoundException("El usuario no tiene publicaciones con productos promocionados");

        String userName = postByUser.get(0).getSeller().getName();
        return new PromoPostCountDto(userId,userName, postByUser.size());
    }

    @Override
    public MessageDto createPromoPost(PromoPostDto dto) {
        Post toRegister = objectMapper.convertValue(dto, Post.class);
        if(!userRepository.exists(dto.getSeller())){
            throw new BadRequestException("Este usuario no existe");
        }
        if(!postCategoryRepository.exists(dto.getCategoryId())){
            throw new BadRequestException("Esta categoria no existe");
        }
        toRegister.setSeller(userRepository.findById(dto.getSeller()));
        toRegister.setPostId(postRepository.findAll().size()+1);
        validatePost(toRegister);
        postRepository.create(toRegister);
        return new MessageDto("Post con promo realizado con exito");
    }

    private void validatePost(Post post){
        if (post.getPublishDate() == null ||
                post.getProduct() == null ||
                post.getProduct().getType() == null ||
                post.getProduct().getColour() == null ||
                post.getProduct().getName() == null ||
                post.getProduct().getBrand() == null)
            throw new BadRequestException("No se ha podido realizar el post");
    }

    public FollowedSellerPostsDto getFollowedSellersPosts(int userId, String order) {
            if(!"date_desc".equals(order) && !"date_asc".equals(order) && order != null)
                throw new BadRequestException("Tipo de order no válido, ingrese date_asc o date_desc");

        if (!userRepository.exists(userId))
            throw new NotFoundException("No se encontró ningún usuario con ese ID.");

        List<PostDto> posts = userRepository.findAll()
                .stream()
                .filter(x -> x.getFollowers().stream().anyMatch(followerId -> followerId.equals(userId)))
                .flatMap(x -> getPostsByUserId(x.getId()).stream())
                .filter(post -> post.getPublishDate() != null &&
                        !post.getPublishDate().isBefore(LocalDate.now().minusWeeks(2)))
                .toList();

        if(order == null)
            return new FollowedSellerPostsDto(userId, posts);

        return new FollowedSellerPostsDto(userId, getSortedPost(posts,order));
    }

    @Override
    public PostDto getPostById(int postId) {
        return objectMapper.convertValue(postRepository.findById(postId), PostDto.class);
    }

    @Override
    public List<PostDto> getPosts() {
        return objectMapper.convertValue(postRepository.findAll(), new TypeReference<List<PostDto>>() {});
    }

    @Override
    public List<PostDto> getPostsByUserId(int userId) {
        List<Post> postsFromRepo = postRepository.findByUserId(userId);
        return objectMapper.convertValue(postsFromRepo, new TypeReference<List<PostDto>>() {});
    }

    private List<PostDto> getSortedPost(List<PostDto> posts, String order){
        return  posts.stream()
                .sorted("date_desc".equals(order)
                        ? Comparator.comparing(PostDto::getPublishDate).reversed()
                        : Comparator.comparing(PostDto::getPublishDate))
                .toList();
    }

    @Override
    public GetByCategoryResponseDto getPostByCategoryId(int categoryId, double price_min, double price_max) {
        PostCategory postCategory = postCategoryRepository.findById(categoryId);

        if (postCategory == null)
            throw new NotFoundException("Categoría invalida");

        List<Post> postByCategory = postRepository.findAll()
                .stream()
                .filter(p -> p.getCategoryId() == categoryId &&
                        p.getPrice() <= price_max && p.getPrice() >= price_min)
                .toList();

        if (postByCategory.isEmpty())
            throw new NotFoundException("No se encontraron post con ese id o rango de precio");

        List<PostDto> posts = objectMapper.convertValue(postByCategory,new TypeReference<List<PostDto>>(){});
        return new GetByCategoryResponseDto(postCategory.getDescription(), posts);
    }
}
