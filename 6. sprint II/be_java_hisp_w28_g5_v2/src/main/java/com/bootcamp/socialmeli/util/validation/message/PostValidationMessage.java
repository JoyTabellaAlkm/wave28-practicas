package com.bootcamp.socialmeli.util.validation.message;

public class PostValidationMessage extends ValidationMessage{
    public static final String CATEGORY_NOT_NULL = "La categoría no puede estar vacía";
    public static final String PRICE_NOT_NULL = "El precio no puede estar vacío";
    public static final String MAX_PRICE = "El precio máximo por producto es de 10.000.000";
    public static final String MIN_PRICE = "El precio minimo por producto debe ser mayor a 0";
    public static final String DISCOUNT_NOT_NULL = "El campo discount no puede estar vacío";
    public static final String MAX_DISCOUNT = "El descuento no puede ser mayor que 1";
    public static final String MIN_DISCOUNT = "El descuento no puede ser menor que 0";
}
