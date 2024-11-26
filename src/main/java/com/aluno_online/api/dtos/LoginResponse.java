package com.aluno_online.api.dtos;

public record LoginResponse(
        String token,
        Long expiraEm
) {
}