package com.barbearia_kawamura.controller;

import com.barbearia_kawamura.dto.LoginDTO;
import com.barbearia_kawamura.entity.Usuario;
import com.barbearia_kawamura.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        Usuario usuario = authService.login(loginDTO);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.status(401).body("Email ou senha inválidos");
    }
}