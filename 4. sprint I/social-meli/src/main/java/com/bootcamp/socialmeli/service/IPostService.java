package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.request.PostDto;
import com.bootcamp.socialmeli.dto.response.ResponseMessageDto;
import com.bootcamp.socialmeli.dto.response.PromoPostsDto;
import com.bootcamp.socialmeli.dto.response.RecentPostsDto;

public interface IPostService {
    RecentPostsDto getRecentFollowedPosts(int userId, String order);

    ResponseMessageDto publishPost(PostDto newPost, boolean isPromo);

    PromoPostsDto getUserPromoCount(int userId);
}
