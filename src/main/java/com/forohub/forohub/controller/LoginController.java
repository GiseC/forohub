package com.forohub.forohub.controller;

import com.forohub.forohub.domain.autores.Autor;
import com.forohub.forohub.domain.autores.DatosValidarAutor;
import com.forohub.forohub.infra.security.DatosJWTtoken;
import com.forohub.forohub.infra.security.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    
    @Operation(
            summary = "Validar usuario",
            description = "Autenticar usuario y obtener su JWT. Se requiere enviar el campo login y clave para poder autenticarse"
    )
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosValidarAutor datosValidarAutor) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosValidarAutor.login(), datosValidarAutor.clave());
        var authentication = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarJWT((Autor) authentication.getPrincipal());
        return ResponseEntity.ok(new DatosJWTtoken(JWTtoken));
    }
}
