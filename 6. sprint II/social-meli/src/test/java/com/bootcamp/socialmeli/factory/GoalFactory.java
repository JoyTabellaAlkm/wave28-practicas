package com.bootcamp.socialmeli.factory;

import com.bootcamp.socialmeli.dto.request.GoalDto;
import com.bootcamp.socialmeli.entity.Goal;

import java.time.LocalDate;

public class GoalFactory {
    public static Goal createGoal() {
        return new Goal(
                13,
                "Grow to 12 Followers",
                12,
                LocalDate.now().plusMonths(1)
        );
    }

    public static GoalDto create100FollowersForNextMonthGoalDto() {
        return new GoalDto(
                4,
                "Follow 100 people",
                100,
                LocalDate.now().plusDays(30)
        );
    }

    public static GoalDto createInvalidDeadlineGoalDto() {
        return new GoalDto(
                5,
                "Follow 100 people",
                100,
                LocalDate.now().minusDays(1)
        );
    }

    public static Goal createDeadlinePassedGoal() {
        return new Goal(
                1,
                "Reach 10 followers",
                10,
                LocalDate.now().minusDays(1)
        );
    }

    public static Goal createDeadlineNotPassedGoal() {
        return new Goal(
                1,
                "Reach 10 followers",
                10,
                LocalDate.now().plusDays(1)
        );
    }
}


