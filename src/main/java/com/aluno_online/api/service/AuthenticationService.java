package com.aluno_online.api.service;

import com.aluno_online.api.dtos.LoginUsuarioRequest;
import com.aluno_online.api.dtos.RegistroUsuarioRequest;
import com.aluno_online.api.model.Usuario;
import com.aluno_online.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public Usuario signup(RegistroUsuarioRequest registroUsuarioRequest) {
        Usuario usuario = new Usuario();
        usuario.setNomeCompleto(registroUsuarioRequest.nomeCompleto());
        usuario.setEmail(registroUsuarioRequest.email());
        usuario.setCpf(registroUsuarioRequest.cpf());


        usuario.setSenha(passwordEncoder.encode(registroUsuarioRequest.senha()));

        return usuarioRepository.save(usuario);
    }

    public Usuario signin(LoginUsuarioRequest loginUsuarioRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUsuarioRequest.email(),
                        loginUsuarioRequest.senha()
                )
        );

        return usuarioRepository.findByEmail(loginUsuarioRequest.email()).orElseThrow();
    }

}