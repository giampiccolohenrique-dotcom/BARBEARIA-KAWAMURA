package com.barbearia_kawamura.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String nome;
    
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(nullable = false, length = 20)
    private String telefone;
    
    @Column(nullable = false)
    private String senha;
    
    @Column(name = "tipo_usuario")
    private String tipoUsuario = "CLIENTE";
    
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
    
    @PrePersist
    protected void onCreate() {
        dataCadastro = LocalDateTime.now();
    }
    
    // GETTERS
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getSenha() { return senha; }
    public String getTipoUsuario() { return tipoUsuario; }
    public LocalDateTime getDataCadastro() { return dataCadastro; }
    
    // SETTERS
    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setSenha(String senha) { this.senha = senha; }
    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
}