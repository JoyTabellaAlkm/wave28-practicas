package com.morse.Codigo.Morse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static com.morse.Codigo.Morse.utlils.CodeMorse.*;
import static com.morse.Codigo.Morse.utlils.CodeMorse.*;

@Service
public class CodeMorseService implements ICodigoMorse{

    @Override
    public String getCodeMorse(String nameToCodeMorseToText) {

        StringBuilder convertToCodeMorse = new StringBuilder();
        String [] toConvertToCodeMorse = nameToCodeMorseToText.split("   ") ;

        for(String word : toConvertToCodeMorse){
            String [] codeMorse = word.split(" ") ;
            for (String code : codeMorse){
                String getCodeMorse = MORSE_A_TEXTO.get(code);
                convertToCodeMorse.append(getCodeMorse);
            }
            convertToCodeMorse.append(" ");
        }

        return convertToCodeMorse.toString();
    }

    @Override
    public String getConvertTextToMorseCode(String nameToTextToCodeMorse) {

        StringBuilder getNameToTextToCodeMorse = new StringBuilder();
        String[] words = nameToTextToCodeMorse.split(" ");

        for (String word: words){
            for (String w : word.split("")){
                    String text = TEXTO_A_MORSE.get(w);
                    getNameToTextToCodeMorse.append(text+ " ");
            }
            getNameToTextToCodeMorse.append("  ");
        }
        return getNameToTextToCodeMorse.toString();
    }

    //Testing stream
    public String getCodeMorseWithStream(String nameToCodeMorseToText) {
        return Arrays.stream(nameToCodeMorseToText.split("   "))
                .map(word -> Arrays.stream(word.split(" "))
                        .map(code -> MORSE_A_TEXTO.get(code))
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(" "));
    }

}
