package com.aluno_online.api.service;

import com.aluno_online.api.model.Disciplina;
import com.aluno_online.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public void create(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> findByProfessorId(UUID professorId) {
        return disciplinaRepository.findByProfessorId(professorId);
    }
}
