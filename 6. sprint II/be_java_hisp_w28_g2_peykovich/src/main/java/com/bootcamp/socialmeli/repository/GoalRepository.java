package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.entity.Goal;
import com.bootcamp.socialmeli.utils.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GoalRepository implements IGoalRepository {
    private List<Goal> goals = new ArrayList<>();

    public GoalRepository() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Goal> findAll() {
        return goals;
    }

    @Override
    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    private void loadDataBase() throws IOException {
        goals = Utils.loadDataBase("goals", new TypeReference<List<Goal>>() {
        });
    }
}
