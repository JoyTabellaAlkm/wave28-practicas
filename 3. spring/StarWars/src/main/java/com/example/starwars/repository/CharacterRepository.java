package com.example.starwars.repository;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.entity.Character;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Data
@Repository
public class CharacterRepository {

   private List<Character> characters = new ArrayList<>();
   public List<Character> findAll() throws IOException {
       ObjectMapper mapper = new ObjectMapper();
       characters = mapper.readValue(new File("src/main/resources/starwars.json"),
               new TypeReference<List<Character>>() {
               });
       return characters;
   }
}
