package com.bootcamp.socialmeli.util.validation.message;

public class ProductValidationMessage extends ValidationMessage{
    public static final String NAME_NOT_NULL = "El nombre no puede estar vacío";
    public static final String NAME_MAX_LENGTH = "La longitud del nombre no puede superar los 40 caracteres";
    public static final String NAME_PATTERN = "El nombre no puede poseer caracteres especiales";
    public static final String TYPE_NOT_NULL = "El tipo no puede estar vacío";
    public static final String TYPE_MAX_LENGTH = "La longitud del tipo no puede superar los 15 caracteres";
    public static final String TYPE_PATTERN = "El tipo no puede poseer caracteres especiales";
    public static final String BRAND_NOT_NULL = "La marca no puede estar vacío";
    public static final String BRAND_MAX_LENGTH = "La longitud de la marca no puede superar los 25 caracteres";
    public static final String BRAND_PATTERN = "El tipo no puede poseer caracteres especiales";
    public static final String COLOR_NOT_NULL = "El color no puede estar vacío";
    public static final String COLOR_MAX_LENGTH = "La longitud del color no puede superar los 15 caracteres";
    public static final String COLOR_PATTERN = "El color no puede poseer caracteres especiales";
    public static final String NOTES_MAX_LENGTH = "La longitud de las notas no puede superar los 80 caracteres";
    public static final String NOTES_PATTERN = "Las notas no puede poseer caracteres especiales";
}
