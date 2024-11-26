package com.aluno_online.api.dtos;

public record LoginUsuarioRequest(
        String email,
        String senha
) {
}