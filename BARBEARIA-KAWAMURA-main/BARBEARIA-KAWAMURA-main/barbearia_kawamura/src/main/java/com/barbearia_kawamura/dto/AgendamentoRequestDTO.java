package com.barbearia_kawamura.dto;

import java.time.LocalDateTime;

public class AgendamentoRequestDTO {
    private Long clienteId;
    private Long barbeiroId;
    private Long servicoId;
    private LocalDateTime dataHora;
    
    // GETTERS
    public Long getClienteId() { return clienteId; }
    public Long getBarbeiroId() { return barbeiroId; }
    public Long getServicoId() { return servicoId; }
    public LocalDateTime getDataHora() { return dataHora; }
    
    // SETTERS
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public void setBarbeiroId(Long barbeiroId) { this.barbeiroId = barbeiroId; }
    public void setServicoId(Long servicoId) { this.servicoId = servicoId; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}