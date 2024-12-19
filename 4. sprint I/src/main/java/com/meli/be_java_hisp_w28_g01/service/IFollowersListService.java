package com.meli.be_java_hisp_w28_g01.service;

import com.meli.be_java_hisp_w28_g01.dto.FollowersListDto;


public interface IFollowersListService {
    FollowersListDto getListOfFollowers (int userID);
    FollowersListDto orderUserByName(int userID, String order);
}
