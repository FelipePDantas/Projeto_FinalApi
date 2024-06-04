package com.aluno_online.api.dtos;

import lombok.Data;

import java.util.List;

@Data
public class HistoricoAlunoResponse {
    private String studentName;
    private String studentEmail;
    private List<DisciplinasAlunoResponse> studentSubjectsResponseList;
}
