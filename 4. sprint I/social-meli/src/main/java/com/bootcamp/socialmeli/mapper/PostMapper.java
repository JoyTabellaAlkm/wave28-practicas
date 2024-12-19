package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.dto.request.PostDto;
import com.bootcamp.socialmeli.dto.response.PromoPostsDto;
import com.bootcamp.socialmeli.dto.response.RecentPostDto;
import com.bootcamp.socialmeli.dto.response.RecentPostsDto;
import com.bootcamp.socialmeli.dto.response.RecentProductDto;
import com.bootcamp.socialmeli.entity.Post;
import com.bootcamp.socialmeli.entity.Product;
import com.bootcamp.socialmeli.entity.User;

import java.util.List;

public class PostMapper {

    public static RecentPostDto mapPostToRecentPostDto(Post post) {
        RecentPostDto postDto = new RecentPostDto();
        RecentProductDto productDto = mapProductToRecentProductDto(post.getProduct());
        postDto.setId(post.getId());
        postDto.setUserId(post.getUserId());
        postDto.setDate(post.getDate());
        postDto.setProduct(productDto);
        postDto.setCategory(post.getCategory());
        postDto.setPrice(post.getProduct().getPrice());
        return postDto;
    }

    public static RecentProductDto mapProductToRecentProductDto(Product product) {
        RecentProductDto productDto = new RecentProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setType(product.getType());
        productDto.setNotes(product.getNotes());
        productDto.setBrand(product.getBrand());
        productDto.setColor(product.getColor());
        return productDto;
    }

    public static RecentPostsDto mapToRecentPostsDto(int userId, List<RecentPostDto> posts) {
        RecentPostsDto recentPostsDto = new RecentPostsDto();
        recentPostsDto.setUserId(userId);
        recentPostsDto.setPosts(posts);
        return recentPostsDto;
    }

    public static PromoPostsDto mapToPromoPostsDto(List<Post> userPostsWithPromo, User user) {
        PromoPostsDto promoPostsDto = new PromoPostsDto();
        promoPostsDto.setUserId(user.getId());
        promoPostsDto.setUserName(user.getName());
        promoPostsDto.setCount(userPostsWithPromo.size());
        return promoPostsDto;
    }

    public static PostDto mapToPostDto(Post p) {

        if (p == null) {
            return null;
        }

        PostDto post = new PostDto();
        post.setId(p.getId());
        post.setUserId(p.getUserId());
        post.setDate(p.getDate());
        post.setProduct(ProductMapper.mapToProductDto(p.getProduct()));
        post.setCategory(p.getCategory());
        post.setHasPromo(p.isHasPromo());
        post.setDiscount(p.getDiscount());
        return post;
    }
}
