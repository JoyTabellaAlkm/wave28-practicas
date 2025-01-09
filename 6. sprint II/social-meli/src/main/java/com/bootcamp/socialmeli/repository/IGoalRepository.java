package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entity.Goal;

import java.util.List;

public interface IGoalRepository {
    List<Goal> findAll();

    void addGoal(Goal goal);
}
