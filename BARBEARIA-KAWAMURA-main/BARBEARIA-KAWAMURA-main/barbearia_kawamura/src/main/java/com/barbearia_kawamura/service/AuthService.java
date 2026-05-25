package com.barbearia_kawamura.service;

import com.barbearia_kawamura.dto.LoginDTO;
import com.barbearia_kawamura.entity.Usuario;
import com.barbearia_kawamura.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Usuario login(LoginDTO loginDTO) {
        Usuario usuario = usuarioRepository.findByEmail(loginDTO.getEmail()).orElse(null);
        
        if (usuario != null && usuario.getSenha().equals(loginDTO.getSenha())) {
            return usuario;
        }
        return null;
    }
}