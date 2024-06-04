package com.aluno_online.api.repository;

import com.aluno_online.api.model.MatriculaAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MatriculaAlunoRepository extends JpaRepository<MatriculaAluno, UUID> {
    List<MatriculaAluno> findByStudentId(UUID studentId);
}
