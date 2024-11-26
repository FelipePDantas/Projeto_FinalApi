package com.aluno_online.api.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrosDetalhes {

    private String error;
    private String detalhes;
}
