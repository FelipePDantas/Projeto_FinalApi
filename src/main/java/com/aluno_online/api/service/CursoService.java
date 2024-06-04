package com.aluno_online.api.service;

import com.aluno_online.api.dtos.CriarCursoRequest;
import com.aluno_online.api.model.Curso;
import com.aluno_online.api.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CursoService {

    @Autowired
    CursoRepository repository;


    public Curso create(Curso curso){

        var cursoCreate = repository.save(curso);
        return cursoCreate;

    }
}
