package com.melibootcamp.morsecode.service;

import com.melibootcamp.morsecode.controllers.MorseCodeController;
import com.melibootcamp.morsecode.repositories.MorseCodeRepository;
import org.springframework.stereotype.Service;

@Service
public class MorseCodeService {
    private MorseCodeRepository morseCodeRepository;

    public MorseCodeService(){
        morseCodeRepository = new MorseCodeRepository();
    }

    public String convertMorseToLatin(String morseCode)
    {
        StringBuilder decodedText = new StringBuilder();
        String[] encryptedText = morseCode.split("   "); // Creates an array consisting of the words split by three spaces

        for(String encryptedWords : encryptedText){
            String[] encryptedLetters = encryptedWords.split(" "); //Creates an array consisting of the letters separated by one space

            for(String letter : encryptedLetters){
                if(morseCodeRepository.checkExistingLetter(letter)){
                    decodedText.append(morseCodeRepository.getLetter(letter));
                }
            }
            decodedText.append(" ");
        }
        return decodedText.toString();
    }


}
