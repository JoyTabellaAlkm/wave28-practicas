package com.mercadolibre.CalCalories.dto;

import java.util.List;

public class DishResponseDTO extends DishDTO{
    private Integer calories;
    private IngredientDTO ingredient;

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public IngredientDTO getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientDTO ingredient) {
        this.ingredient = ingredient;
    }

    public DishResponseDTO(DishDTO dish) {
        this.setIngredients(dish.getIngredients());
        this.setName(dish.getName());
    }
    public void setCaloric(IngredientDTO caloric) {
        this.ingredient = caloric;
    }

}
