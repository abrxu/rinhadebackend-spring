package com.rinhadebackend.q1_spring.service;

import com.rinhadebackend.q1_spring.domain.transacao.Transacao;
import com.rinhadebackend.q1_spring.dtos.ExtratoResponseDTO;
import com.rinhadebackend.q1_spring.dtos.SaldoResponseDTO;
import com.rinhadebackend.q1_spring.dtos.TransacoesResponseDTO;
import com.rinhadebackend.q1_spring.exceptions.ClienteNotFoundException;
import com.rinhadebackend.q1_spring.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExtratoService {

    @Autowired
    ClienteRepository clienteRepository;

    public ExtratoResponseDTO visualizarExtrato(Integer id) {
        var cliente = clienteRepository.findClienteById(id);
        if (cliente == null) {
            throw new ClienteNotFoundException("Cliente não foi encontrado");
        }
        var saldo = new SaldoResponseDTO(cliente.getTotal(), Instant.now(), cliente.getLimite());
        var transacoes = clienteRepository.findAllTransacaoById(id);
        List<TransacoesResponseDTO> ultimas_transacoes = new ArrayList<>();
        for (Transacao transacao : transacoes) {
            ultimas_transacoes.add(new TransacoesResponseDTO(transacao.getValor(), transacao.getTipo(), transacao.getDescricao(), transacao.getRealizadaEm()));
        }
        return new ExtratoResponseDTO(saldo, ultimas_transacoes);
    }
}
