package com.mercadolibre.CalCalories.dto;

public class IngredientDTO {
    private String name;
    private Integer calories;
    private Integer weight;

    public IngredientDTO(Integer calories, String name) {
        this.calories = calories;
        this.name = name;
    }

    public IngredientDTO(String name, Integer calories, Integer weight) {
        this.name = name;
        this.calories = calories;
        this.weight = weight;
    }

    public IngredientDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
