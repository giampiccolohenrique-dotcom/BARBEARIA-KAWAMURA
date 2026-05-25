package com.barbearia_kawamura.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "servicos")
public class Servico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String nome;
    
    @Column(length = 500)
    private String descricao;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;
    
    @Column(name = "duracao_minutos")
    private Integer duracaoMinutos = 30;
    
    private Boolean ativo = true;
    
    // GETTERS
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public BigDecimal getValor() { return valor; }
    public Integer getDuracaoMinutos() { return duracaoMinutos; }
    public Boolean getAtivo() { return ativo; }
    
    // SETTERS
    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
    public void setDuracaoMinutos(Integer duracaoMinutos) { this.duracaoMinutos = duracaoMinutos; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}