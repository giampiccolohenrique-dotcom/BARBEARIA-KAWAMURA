package com.barbearia_kawamura.service;

import com.barbearia_kawamura.entity.Cliente;
import com.barbearia_kawamura.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
    
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
    
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}