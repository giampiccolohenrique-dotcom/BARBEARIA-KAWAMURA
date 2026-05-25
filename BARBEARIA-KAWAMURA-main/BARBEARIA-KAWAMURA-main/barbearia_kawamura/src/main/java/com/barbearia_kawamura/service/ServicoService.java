package com.barbearia_kawamura.service;

import com.barbearia_kawamura.entity.Servico;
import com.barbearia_kawamura.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicoService {
    
    @Autowired
    private ServicoRepository servicoRepository;
    
    public List<Servico> listarTodos() {
        return servicoRepository.findAll();
    }
    
    public Servico buscarPorId(Long id) {
        return servicoRepository.findById(id).orElse(null);
    }
    
    public Servico salvar(Servico servico) {
        return servicoRepository.save(servico);
    }
}