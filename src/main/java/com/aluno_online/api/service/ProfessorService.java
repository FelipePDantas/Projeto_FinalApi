package com.aluno_online.api.service;

import com.aluno_online.api.model.Professor;
import com.aluno_online.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    public void create(Professor professor) {
        professorRepository.save(professor);
   }

}
