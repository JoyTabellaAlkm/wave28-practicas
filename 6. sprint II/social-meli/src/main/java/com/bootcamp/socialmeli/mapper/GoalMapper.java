package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.dto.request.GoalDto;
import com.bootcamp.socialmeli.dto.response.GoalResponseDto;
import com.bootcamp.socialmeli.entity.Goal;
import com.bootcamp.socialmeli.entity.User;

public class GoalMapper {
    public static Goal mapToGoal(GoalDto goalDto) {
        Goal goal = new Goal();
        goal.setId(goalDto.getId());
        goal.setName(goalDto.getName());
        goal.setTargetFollowers(goalDto.getTargetFollowers());
        goal.setDeadline(goalDto.getDeadline());

        return goal;
    }

    public static GoalResponseDto mapToGoalResponseDto(Goal goal, User user) {
        GoalResponseDto goalResponseDto = new GoalResponseDto();
        goalResponseDto.setUserId(user.getId());
        goalResponseDto.setId(goal.getId());
        goalResponseDto.setName(goal.getName());
        goalResponseDto.setTargetFollowers(goal.getTargetFollowers());
        goalResponseDto.setCurrentFollowers(user.getFollowers().size());
        goalResponseDto.setDeadline(goal.getDeadline());
        goalResponseDto.setStatus(goal.currentStatusFor(user));

        return goalResponseDto;
    }
}
