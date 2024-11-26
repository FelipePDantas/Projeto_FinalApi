package com.aluno_online.api.dtos;


public record RegistroUsuarioRequest(
        String email,
        String senha,
        String nomeCompleto,
        String cpf
) {
}