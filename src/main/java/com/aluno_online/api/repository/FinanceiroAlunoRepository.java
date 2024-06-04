package com.aluno_online.api.repository;

import com.aluno_online.api.model.FinanceiroAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FinanceiroAlunoRepository extends JpaRepository<FinanceiroAluno, UUID> {
}
