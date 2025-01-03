package com.mercadolibre.starwars.util;

import java.util.List;

import com.mercadolibre.starwars.dto.CharacterDTO;

public final class TestUtilsGenerator {

  public static List<CharacterDTO> generateDarthCharacters() {
    CharacterDTO darthVader = new CharacterDTO();
    darthVader.setName("Darth Vader");
    darthVader.setHeight(202);
    darthVader.setMass(136);
    darthVader.setHair_color("none");
    darthVader.setSkin_color("white");
    darthVader.setEye_color("yellow");
    darthVader.setBirth_year("41.9BBY");
    darthVader.setGender("male");
    darthVader.setHomeworld("Tatooine");
    darthVader.setSpecies("Human");

    CharacterDTO darthMaul = new CharacterDTO();
    darthMaul.setName("Darth Maul");
    darthMaul.setHeight(175);
    darthMaul.setMass(80);
    darthMaul.setHair_color("none");
    darthMaul.setSkin_color("red");
    darthMaul.setEye_color("yellow");
    darthMaul.setBirth_year("54BBY");
    darthMaul.setGender("male");
    darthMaul.setHomeworld("Dathomir");
    darthMaul.setSpecies("Zabrak");

    return List.of(darthVader, darthMaul);
  }

}
