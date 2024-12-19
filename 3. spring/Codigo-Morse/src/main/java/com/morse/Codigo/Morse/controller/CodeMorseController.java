package com.morse.Codigo.Morse.controller;

import com.morse.Codigo.Morse.service.CodeMorseService;
import com.morse.Codigo.Morse.service.ICodigoMorse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codeMorse")
public class CodeMorseController{

    private final ICodigoMorse iCodeMorse;

    public CodeMorseController(ICodigoMorse codeMorse) {
        this.iCodeMorse = codeMorse;
    }

    @GetMapping("/getCodeMorse")
    ResponseEntity<?> getCodeMorse(@RequestParam String codeMorse) {
        return new ResponseEntity<>(iCodeMorse.getCodeMorse(codeMorse), HttpStatus.OK);
    }

    @GetMapping("/getText")
    ResponseEntity<?> getToTextToCodeMorse(@RequestParam String codeMorse){
        return new ResponseEntity<>(iCodeMorse.getConvertTextToMorseCode(codeMorse), HttpStatus.OK);
    }
}
