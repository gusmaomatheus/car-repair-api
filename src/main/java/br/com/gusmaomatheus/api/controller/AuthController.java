package br.com.gusmaomatheus.api.controller;

import br.com.gusmaomatheus.api.application.auth.JWTService;
import br.com.gusmaomatheus.api.model.dto.DadosAuth;
import br.com.gusmaomatheus.api.model.dto.DadosRespostaLogin;
import br.com.gusmaomatheus.api.model.entity.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JWTService tokenService;

    public AuthController(AuthenticationManager authenticationManager, JWTService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DadosAuth dados) {
        final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        final Authentication authenticate = authenticationManager.authenticate(token);
        final String authToken = tokenService.gerarToken((Usuario) authenticate.getPrincipal());

        return ResponseEntity.ok(new DadosRespostaLogin(authToken));
    }
}