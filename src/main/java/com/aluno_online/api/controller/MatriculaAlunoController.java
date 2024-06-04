package com.aluno_online.api.controller;

import com.aluno_online.api.dtos.AtualizarNotasRequest;
import com.aluno_online.api.dtos.HistoricoAlunoResponse;
import com.aluno_online.api.model.MatriculaAluno;
import com.aluno_online.api.service.MatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/matricula-aluno")
public class MatriculaAlunoController {

    @Autowired
    MatriculaAlunoService matriculaAlunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MatriculaAluno matriculaAluno) {
        matriculaAlunoService.create(matriculaAluno);
    }

    @PatchMapping("/update-grades/{matriculaAlunoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGrades(@RequestBody AtualizarNotasRequest atualizarNotasRequest,
                             @PathVariable UUID matriculaAlunoId) {
        matriculaAlunoService.updateGrades(matriculaAlunoId, atualizarNotasRequest);
    }

    @PatchMapping("/update-status-to-break/{matriculaAlunoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatusToBreak(@PathVariable UUID matriculaAlunoId) {
        matriculaAlunoService.updateStatusToBreak(matriculaAlunoId);
    }

    @GetMapping("/academic-transcript/{alunoId}")
    @ResponseStatus(HttpStatus.OK)
    public HistoricoAlunoResponse getAcademicTranscript(@PathVariable UUID alunoId) {
        return matriculaAlunoService.getAcademicTranscript(alunoId);
    }

}