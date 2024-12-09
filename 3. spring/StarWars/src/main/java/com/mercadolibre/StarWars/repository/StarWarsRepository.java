package com.mercadolibre.StarWars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.StarWars.entity.CharacterEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StarWarsRepository implements IStarWarsRepository{

    @Override
    public List<CharacterEntity> getNames() {
        return LoadDataBase();
    }

    @Override
    public CharacterEntity addCharacter(CharacterEntity character) {
        ObjectMapper objectMapper = new ObjectMapper();

        List<CharacterEntity> data;
        File file = new File("starwars.json");

        try {
            // 1. Cargar la lista existente desde el archivo JSON, si existe
            if (file.exists()) {
                data = objectMapper.readValue(file, new TypeReference<List<CharacterEntity>>() {});
            } else {
                data = new ArrayList<>(); // Crear nueva lista si el archivo no existe
            }

            // 2. Agregar el nuevo carácter a la lista
            data.add(character);

            // 3. Guardar la lista actualizada en el archivo JSON
            objectMapper.writeValue(file, data); // Escribe la variable `data` en el archivo JSON

        } catch (IOException e) {
            e.printStackTrace(); // Manejo de excepciones
            return null; // O lanzar una excepción
        }

        return character; // Retornar el carácter agregado
    }

    @Override
    public CharacterEntity putCharacter(int id, CharacterEntity character) {
        return null;
    }

    @Override
    public boolean deleteCharacter(int id) {
        return false;
    }

    public List<CharacterEntity> LoadDataBase(){
        File file = null;
        List<CharacterEntity> caracters = new ArrayList<>();
        ObjectMapper obj = new ObjectMapper();
        TypeReference<List<CharacterEntity>> typeRef = new TypeReference<List<CharacterEntity>>(){};
        try{
            file = ResourceUtils.getFile("classpath:starwars.json");
        }catch (FileNotFoundException exp){
            exp.printStackTrace();
        }
        try{
            caracters = obj.readValue(file, typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }
        return caracters;
    }
}
