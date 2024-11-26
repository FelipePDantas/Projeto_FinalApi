package com.aluno_online.api.controller;


import com.aluno_online.api.dtos.LoginResponse;
import com.aluno_online.api.dtos.LoginUsuarioRequest;
import com.aluno_online.api.dtos.RegistroUsuarioRequest;
import com.aluno_online.api.model.Usuario;
import com.aluno_online.api.service.AuthenticationService;
import com.aluno_online.api.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario signup(@RequestBody RegistroUsuarioRequest registroUsuarioRequest) {
        return authenticationService.signup(registroUsuarioRequest);
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse signin(@RequestBody LoginUsuarioRequest loginUsuarioRequest) {
        Usuario usuarioLogado = authenticationService.signin(loginUsuarioRequest);

        String jwtToken = jwtService.generateToken(usuarioLogado);

        return new LoginResponse(jwtToken, jwtService.getExpirationTime());
    }

}