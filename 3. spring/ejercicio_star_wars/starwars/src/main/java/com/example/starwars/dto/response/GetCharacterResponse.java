package com.example.starwars.dto.response;

import com.example.starwars.dto.CharacterDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCharacterResponse {
    private List<CharacterDTO> characters;
}
