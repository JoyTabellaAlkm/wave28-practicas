package com.bootcamp.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class GoalResponseDto {
    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("goal_id")
    private int id;

    @JsonProperty("goal_name")
    private String name;

    @JsonProperty("target_followers")
    private int targetFollowers;

    @JsonProperty("current_followers")
    private int currentFollowers;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate deadline;

    private String status;
}
