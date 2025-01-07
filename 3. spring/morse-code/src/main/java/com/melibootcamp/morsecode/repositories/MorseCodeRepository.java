package com.melibootcamp.morsecode.repositories;

import com.melibootcamp.morsecode.controllers.MorseCodeController;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MorseCodeRepository {
    private Map<String, Character> letterList = new HashMap<>();

    public MorseCodeRepository(){
        letterList.put(".-", 'a');
        letterList.put("-...", 'b');
        letterList.put("-.-.", 'c');
        letterList.put("-..", 'd');
        letterList.put(".", 'e');
        letterList.put("..-.", 'f');
        letterList.put("--.", 'g');
        letterList.put("....", 'h');
        letterList.put("..", 'i');
        letterList.put(".---", 'j');
        letterList.put("-.", 'k');
        letterList.put(".-..", 'l');
        letterList.put("--", 'm');
        letterList.put("-.", 'n');
        letterList.put("---", 'o');
        letterList.put(".--.", 'p');
        letterList.put("--.-", 'q');
        letterList.put(".-.", 'r');
        letterList.put("...", 's');
        letterList.put("-", 't');
        letterList.put("..-", 'u');
        letterList.put("...-", 'v');
        letterList.put(".--", 'w');
        letterList.put("-..-", 'x');
        letterList.put("-.--", 'y');
        letterList.put("--..", 'z');
        letterList.put(".----", '1');
        letterList.put("..---", '2');
        letterList.put("...--", '3');
        letterList.put("....-", '4');
        letterList.put(".....", '5');
        letterList.put("-....", '6');
        letterList.put("--...", '7');
        letterList.put("---..", '8');
        letterList.put("----.", '9');
        letterList.put("-----", '0');
    }

    public Map<String, Character> getLetterList(){
        return letterList;
    }

    public boolean checkExistingLetter(String toCheck){
        return letterList.containsKey(toCheck);
    }

    public Character getLetter(String key){
        return letterList.get(key);
    }

}
