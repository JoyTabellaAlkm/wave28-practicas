package com.spring1.meliSocial.mapper;

import com.spring1.meliSocial.dto.response.FollowedDto;
import com.spring1.meliSocial.dto.response.FollowerDto;
import com.spring1.meliSocial.dto.response.ProductDto;
import com.spring1.meliSocial.dto.response.ResponsePostDto;
import com.spring1.meliSocial.model.Post;
import com.spring1.meliSocial.model.User;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Mapper implements IMapper{
    @Override
    public ResponsePostDto mapToResponsePostDto(Post post) {
        return new ResponsePostDto(
                post.getId(),
                post.getUserId(),
                post.getDate(),
                new ProductDto(post.getProduct().getId(),
                        post.getProduct().getName(),
                        post.getProduct().getType(),
                        post.getProduct().getBrand(),
                        post.getProduct().getColor(),
                        post.getProduct().getNotes()),
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount());
    }

    @Override
    public FollowedDto mapToFollowedDto(User user) {
        return new FollowedDto(user.getId(), user.getUserName());
    }

    @Override
    public FollowerDto mapToFollowerDto(User user) {
        return new FollowerDto(user.getId(), user.getUserName());
    }
}
