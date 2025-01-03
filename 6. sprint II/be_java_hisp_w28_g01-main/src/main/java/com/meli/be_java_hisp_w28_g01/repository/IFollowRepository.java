package com.meli.be_java_hisp_w28_g01.repository;

import com.meli.be_java_hisp_w28_g01.model.Buyer;
import com.meli.be_java_hisp_w28_g01.model.Follow;
import com.meli.be_java_hisp_w28_g01.model.Seller;

import java.util.List;

public interface IFollowRepository {
    List<Follow> getAll();
    Follow addFollow(Follow newFollow);
    Follow deleteFollow(int userId, int userIdToUnfollow);
}
