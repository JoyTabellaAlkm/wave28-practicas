package com.spring1.meliSocial.mapper;

import com.spring1.meliSocial.dto.response.FollowedDto;
import com.spring1.meliSocial.dto.response.FollowerDto;
import com.spring1.meliSocial.dto.response.ResponsePostDto;
import com.spring1.meliSocial.model.Post;
import com.spring1.meliSocial.model.User;

public interface IMapper {
    ResponsePostDto mapToResponsePostDto(Post post);

    FollowedDto mapToFollowedDto(User user);

    FollowerDto mapToFollowerDto(User user);
}
