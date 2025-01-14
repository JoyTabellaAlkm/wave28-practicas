package com.bootcamp.obrasLiterarias.controller;

import com.bootcamp.obrasLiterarias.model.ObraLiteraria;
import com.bootcamp.obrasLiterarias.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/obra")
public class ObrasLiterariasController {
    @Autowired
    private IObraLiterariaService obraLiterariaService;

    @PostMapping("/new")
    public ObraLiteraria save (@RequestBody ObraLiteraria artic) {
        return obraLiterariaService.save(artic);
    }

    @GetMapping
    public List<ObraLiteraria> findAll () {

        return obraLiterariaService.findAll();
    }

    @GetMapping ("/{id}")
    //va optional porque puede que devuelva como puede que no
    public Optional<ObraLiteraria> findById(@PathVariable Long id) {
        return obraLiterariaService.findById(id);
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteArticle (@PathVariable Long id) {

        return obraLiterariaService.deleteObra(id);
    }

    @PutMapping("/edit")
    public String editArticle (@RequestBody ObraLiteraria obra) {

        return obraLiterariaService.editObra(obra);
    }
}
