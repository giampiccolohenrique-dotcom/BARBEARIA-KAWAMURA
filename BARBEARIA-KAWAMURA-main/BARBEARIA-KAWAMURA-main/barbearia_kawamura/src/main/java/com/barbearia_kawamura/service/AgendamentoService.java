package com.barbearia_kawamura.service;

import com.barbearia_kawamura.dto.AgendamentoRequestDTO;
import com.barbearia_kawamura.entity.Agendamento;
import com.barbearia_kawamura.entity.Cliente;
import com.barbearia_kawamura.entity.Servico;
import com.barbearia_kawamura.mapper.AgendamentoMapper;
import com.barbearia_kawamura.repository.AgendamentoRepository;
import com.barbearia_kawamura.repository.ClienteRepository;
import com.barbearia_kawamura.repository.ServicoRepository;
import com.barbearia_kawamura.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AgendamentoService {
    
    @Autowired
    private AgendamentoRepository agendamentoRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ServicoRepository servicoRepository;
    
    @Autowired
    private AgendamentoMapper agendamentoMapper;
    
    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }
    
    public List<Agendamento> buscarPorCliente(Long clienteId) {
        return agendamentoRepository.findByClienteId(clienteId);
    }
    
    public List<Agendamento> buscarPorBarbeiro(Long barbeiroId) {
        return agendamentoRepository.findByBarbeiroId(barbeiroId);
    }
    
    public Agendamento salvar(AgendamentoRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElse(null);
        Cliente barbeiro = clienteRepository.findById(dto.getBarbeiroId()).orElse(null);
        Servico servico = servicoRepository.findById(dto.getServicoId()).orElse(null);
        
        if (!DateUtils.isHorarioFuncionamento(dto.getDataHora())) {
            throw new RuntimeException("Horário fora do funcionamento!");
        }
        
        boolean horarioOcupado = agendamentoRepository.existsByBarbeiroIdAndDataHora(dto.getBarbeiroId(), dto.getDataHora());
        if (horarioOcupado) {
            throw new RuntimeException("Horário já ocupado!");
        }
        
        Agendamento agendamento = agendamentoMapper.toEntity(dto, cliente, barbeiro, servico);
        return agendamentoRepository.save(agendamento);
    }
    
    public void deletar(Long id) {
        agendamentoRepository.deleteById(id);
    }
}