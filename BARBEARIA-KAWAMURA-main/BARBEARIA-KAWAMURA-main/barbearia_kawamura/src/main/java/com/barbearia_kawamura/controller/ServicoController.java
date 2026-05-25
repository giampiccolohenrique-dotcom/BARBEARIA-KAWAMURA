package com.barbearia_kawamura.controller;

import com.barbearia_kawamura.entity.Servico;
import com.barbearia_kawamura.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {
    
    @Autowired
    private ServicoService servicoService;
    
    @GetMapping
    public List<Servico> listar() {
        return servicoService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public Servico buscar(@PathVariable Long id) {
        return servicoService.buscarPorId(id);
    }
    
    @PostMapping
    public Servico salvar(@RequestBody Servico servico) {
        return servicoService.salvar(servico);
    }
}