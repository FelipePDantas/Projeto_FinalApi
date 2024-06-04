package com.aluno_online.api.dtos;

import com.aluno_online.api.enums.CursoTypeEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CriarCursoRequest {

    private String nome;

    private CursoTypeEnum type;

    private BigDecimal monthlyCost;
}
