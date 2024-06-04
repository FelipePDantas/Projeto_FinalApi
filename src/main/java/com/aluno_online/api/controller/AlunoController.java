package com.aluno_online.api.controller;

import com.aluno_online.api.dtos.CriarAlunoRequest;
import com.aluno_online.api.model.Aluno;
import com.aluno_online.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CriarAlunoRequest criarAlunoRequest) {
        alunoService.create(criarAlunoRequest);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> findAll() {
        return alunoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> findById(@PathVariable UUID id) {
        return alunoService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Aluno aluno, @PathVariable UUID id) {
        alunoService.update(id, aluno);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        alunoService.deleteById(id);
    }
}