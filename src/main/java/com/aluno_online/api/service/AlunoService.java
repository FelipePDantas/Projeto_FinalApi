package com.aluno_online.api.service;

import com.aluno_online.api.dtos.CriarAlunoRequest;
import com.aluno_online.api.enums.FinanceiroStatusEnum;
import com.aluno_online.api.model.Aluno;
import com.aluno_online.api.model.Curso;
import com.aluno_online.api.model.FinanceiroAluno;
import com.aluno_online.api.repository.AlunoRepository;
import com.aluno_online.api.repository.CursoRepository;
import com.aluno_online.api.repository.FinanceiroAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    FinanceiroAlunoRepository financeiroAlunoRepository;

    @Autowired
    CursoRepository cursoRepository;

    public void create(CriarAlunoRequest criarAlunoRequest) {
        Curso curso = cursoRepository.findById(criarAlunoRequest.getCourseId())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));

        Aluno alunoSaved = alunoRepository.save(
                new Aluno(
                        null,
                        criarAlunoRequest.getName(),
                        criarAlunoRequest.getEmail(),
                        curso
                )
        );

        createFinanceiroInformation(alunoSaved, criarAlunoRequest);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(UUID id) {
        return alunoRepository.findById(id);
    }

    public void update(UUID id, Aluno aluno) {
        Optional<Aluno> alunoFromDb = findById(id);

        if (alunoFromDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado no banco de dados");
        }

        Aluno alunoUpdated = alunoFromDb.get();

        alunoUpdated.setName(aluno.getName());
        alunoUpdated.setEmail(aluno.getEmail());

        alunoRepository.save(alunoUpdated);
    }

    public void deleteById(UUID id) {
        alunoRepository.deleteById(id);
    }

    public void createFinanceiroInformation(Aluno aluno, CriarAlunoRequest criarAlunoRequest) {
        FinanceiroAluno financeiroAluno = new FinanceiroAluno(
                null,
                aluno,
                criarAlunoRequest.getDiscount(),
                criarAlunoRequest.getDueDate(),
                FinanceiroStatusEnum.EM_DIA
        );

        financeiroAlunoRepository.save(financeiroAluno);
    }
}
