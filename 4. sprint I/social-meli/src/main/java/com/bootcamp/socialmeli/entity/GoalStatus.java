package com.bootcamp.socialmeli.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public enum GoalStatus {
    @JsonProperty("in_progress")
    IN_PROGRESS("La meta aún no se ha cumplido."),

    @JsonProperty("completed")
    COMPLETED("La meta ha sido alcanzada."),

    @JsonProperty("expired")
    EXPIRED("La meta no se logró antes de la fecha límite."),

    @JsonProperty("finished")
    FINISHED("La meta ya terminó.");

    private final String description;

    GoalStatus(String description) {
        this.description = description;
    }
}
