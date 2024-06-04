package com.aluno_online.api.controller;

import com.aluno_online.api.model.Curso;
import com.aluno_online.api.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    CursoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Curso curso){

        Curso cursoCreate = service.create(curso);


    }
}
