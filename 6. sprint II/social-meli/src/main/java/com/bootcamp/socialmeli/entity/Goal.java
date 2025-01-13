package com.bootcamp.socialmeli.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goal {
    private int id;

    private String name;

    @JsonProperty("target_followers")
    private int targetFollowers;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;

    public String currentStatusFor(User user) {
        boolean isDeadlineMet = deadline.isBefore(LocalDate.now());
        boolean isFollowersTargetMet = user.hasReachedFollowerCount(targetFollowers);

        if (isDeadlineMet && !isFollowersTargetMet)
            return GoalStatus.EXPIRED.getDescription();

        if (!isDeadlineMet && isFollowersTargetMet)
            return GoalStatus.COMPLETED.getDescription();

        if (!isDeadlineMet && !isFollowersTargetMet)
            return GoalStatus.IN_PROGRESS.getDescription();

        return GoalStatus.FINISHED.getDescription();
    }
}
