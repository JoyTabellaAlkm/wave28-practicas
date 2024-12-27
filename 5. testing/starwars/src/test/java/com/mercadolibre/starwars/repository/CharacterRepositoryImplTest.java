package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CharacterRepositoryImplTest {

 CharacterRepository repository = new CharacterRepositoryImpl();


 @Test
 public void findAllByNameContainsOK(){
     //arrange
     String request = "Luke";
     //act
     List<CharacterDTO> response = repository.findAllByNameContains(request);
     //assertion
     Assertions.assertNotNull(response);
 }
}
