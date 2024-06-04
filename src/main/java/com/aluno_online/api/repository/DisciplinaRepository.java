package com.aluno_online.api.repository;

import com.aluno_online.api.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, UUID> {
    List<Disciplina> findByProfessorId(UUID professorId);
}
