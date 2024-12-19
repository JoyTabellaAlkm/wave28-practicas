package com.meli.be_java_hisp_w28_g01.repository.impl;

import com.meli.be_java_hisp_w28_g01.model.Follow;
import com.meli.be_java_hisp_w28_g01.repository.IFollowRepository;
import com.meli.be_java_hisp_w28_g01.util.DataLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FollowRepositoryImpl implements IFollowRepository {
    private final List<Follow> follows;

    public FollowRepositoryImpl(DataLoader dataLoader, @Value("${follow.file.path}") String filePath) {
        this.follows = dataLoader.loadDataBase(filePath, Follow.class);
    }

    @Override
    public List<Follow> getAll() {
        return follows;
    }

    @Override
    public Follow addFollow(Follow newFollow) {
        follows.add(newFollow);
        return newFollow;
    }

    @Override
    public Follow deleteFollow(int userId, int userIdToUnfollow) {
        Follow followToDelete = follows.stream().filter(f -> f.getBuyer().getId() == userId && f.getSeller().getId() == userIdToUnfollow).findFirst().orElse(null);
        follows.remove(followToDelete);
        return followToDelete;
    }

}
