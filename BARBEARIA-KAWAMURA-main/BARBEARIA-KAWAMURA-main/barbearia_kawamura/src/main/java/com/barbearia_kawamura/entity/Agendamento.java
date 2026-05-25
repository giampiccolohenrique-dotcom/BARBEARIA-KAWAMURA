package com.barbearia_kawamura.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
public class Agendamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "barbeiro_id", nullable = false)
    private Cliente barbeiro;
    
    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;
    
    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;
    
    private String status = "AGENDADO";
    
    @Column(name = "data_agendamento")
    private LocalDateTime dataAgendamento;
    
    @PrePersist
    protected void onCreate() {
        dataAgendamento = LocalDateTime.now();
    }
    
    // ===== SETTERS =====
    public void setId(Long id) { this.id = id; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setBarbeiro(Cliente barbeiro) { this.barbeiro = barbeiro; }
    public void setServico(Servico servico) { this.servico = servico; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    public void setStatus(String status) { this.status = status; }
    public void setDataAgendamento(LocalDateTime dataAgendamento) { this.dataAgendamento = dataAgendamento; }
    
    // ===== GETTERS =====
    public Long getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Cliente getBarbeiro() { return barbeiro; }
    public Servico getServico() { return servico; }
    public LocalDateTime getDataHora() { return dataHora; }
    public String getStatus() { return status; }
    public LocalDateTime getDataAgendamento() { return dataAgendamento; }
}