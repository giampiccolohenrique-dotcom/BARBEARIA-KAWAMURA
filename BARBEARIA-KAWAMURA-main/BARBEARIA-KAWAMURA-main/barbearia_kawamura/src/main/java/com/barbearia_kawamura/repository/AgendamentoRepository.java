package com.barbearia_kawamura.repository;

import com.barbearia_kawamura.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    
    List<Agendamento> findByClienteId(Long clienteId);
    
    List<Agendamento> findByBarbeiroId(Long barbeiroId);
    
    @Query("SELECT a FROM Agendamento a WHERE a.barbeiro.id = :barbeiroId AND a.dataHora BETWEEN :inicio AND :fim")
    List<Agendamento> findAgendamentosByBarbeiroAndPeriodo(
        @Param("barbeiroId") Long barbeiroId,
        @Param("inicio") LocalDateTime inicio,
        @Param("fim") LocalDateTime fim
    );
    
    boolean existsByBarbeiroIdAndDataHora(Long barbeiroId, LocalDateTime dataHora);
}