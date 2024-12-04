package com.morseExercise.morseTranslatorApi.service;

import java.util.List;

public interface IMorseTranslatorService {

    List<String> characters = List.of();

    public abstract List<String> split(String encodedMorse);

    public abstract Character translateCharacter(String encodedMorseCharacter);

    public List<Character> translateWord(String encodedWord);
}
