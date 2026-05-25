package com.barbearia_kawamura.dto;

public class LoginDTO {
    private String email;
    private String senha;
    
    // GETTERS
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    
    // SETTERS
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String senha) { this.senha = senha; }
}