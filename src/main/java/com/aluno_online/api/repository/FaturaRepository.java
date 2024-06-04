package com.aluno_online.api.repository;

import com.aluno_online.api.model.Fatura;
import com.aluno_online.api.model.FinanceiroAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, UUID> {
    boolean existsByStudentFinancialAndDueDate(FinanceiroAluno studentFinancial, LocalDateTime dueDate);
}
