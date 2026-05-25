package com.barbearia_kawamura.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios_auth")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String senha;
    
    @Column(nullable = false)
    private String tipo;
    
    // GETTERS
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public String getTipo() { return tipo; }
    
    // SETTERS
    public void setId(Long id) { this.id = id; }
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String senha) { this.senha = senha; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}