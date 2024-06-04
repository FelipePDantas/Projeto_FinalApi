package com.aluno_online.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriarAlunoRequest {
    private String name;
    private String email;
    private UUID courseId;
    private Double discount;
    private Integer dueDate;
}
