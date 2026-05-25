package com.barbearia_kawamura.controller;

import com.barbearia_kawamura.dto.AgendamentoRequestDTO;
import com.barbearia_kawamura.entity.Agendamento;
import com.barbearia_kawamura.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {
    
    @Autowired
    private AgendamentoService agendamentoService;
    
    @GetMapping
    public List<Agendamento> listar() {
        return agendamentoService.listarTodos();
    }
    
    @GetMapping("/cliente/{clienteId}")
    public List<Agendamento> buscarPorCliente(@PathVariable Long clienteId) {
        return agendamentoService.buscarPorCliente(clienteId);
    }
    
    @GetMapping("/barbeiro/{barbeiroId}")
    public List<Agendamento> buscarPorBarbeiro(@PathVariable Long barbeiroId) {
        return agendamentoService.buscarPorBarbeiro(barbeiroId);
    }
    
    @PostMapping
    public Agendamento salvar(@RequestBody AgendamentoRequestDTO dto) {
        return agendamentoService.salvar(dto);
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        agendamentoService.deletar(id);
    }
}