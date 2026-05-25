package com.barbearia_kawamura.mapper;

import com.barbearia_kawamura.dto.AgendamentoRequestDTO;
import com.barbearia_kawamura.entity.Agendamento;
import com.barbearia_kawamura.entity.Cliente;
import com.barbearia_kawamura.entity.Servico;
import org.springframework.stereotype.Component;

@Component
public class AgendamentoMapper {
    
    public Agendamento toEntity(AgendamentoRequestDTO dto, Cliente cliente, Cliente barbeiro, Servico servico) {
        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(cliente);
        agendamento.setBarbeiro(barbeiro);
        agendamento.setServico(servico);
        agendamento.setDataHora(dto.getDataHora());
        return agendamento;
    }
}