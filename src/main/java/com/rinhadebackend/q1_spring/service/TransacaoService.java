package com.rinhadebackend.q1_spring.service;

import com.rinhadebackend.q1_spring.domain.cliente.Cliente;
import com.rinhadebackend.q1_spring.domain.transacao.Transacao;
import com.rinhadebackend.q1_spring.dtos.TransacaoRequestDTO;
import com.rinhadebackend.q1_spring.dtos.TransacaoResponseDTO;
import com.rinhadebackend.q1_spring.repositories.ClienteRepository;
import com.rinhadebackend.q1_spring.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TransacaoService {

    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public ResponseEntity realizarTransacao(Integer id, TransacaoRequestDTO data) {
        Cliente cliente = clienteRepository.findClienteById(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }

        if (data.descricao() == null
                || data.descricao().length() > 10
                || (!data.tipo().equalsIgnoreCase("d")
                && !data.tipo().equalsIgnoreCase("c"))
                || data.valor() <= 0) {
            return ResponseEntity.unprocessableEntity().build();
        }

        int novoSaldo = cliente.getTotal();
        if (data.tipo().equalsIgnoreCase("d")) {
            novoSaldo -= data.valor();
            if (novoSaldo < -cliente.getLimite()) {
                return ResponseEntity.unprocessableEntity().build();
            }
        } else {
            novoSaldo -= data.valor();
        }

        cliente.setTotal(novoSaldo);
        var clienteDb = clienteRepository.save(cliente);
        transacaoRepository.save(new Transacao(cliente, data.valor(), data.tipo(), data.descricao(), Instant.now()));

        TransacaoResponseDTO response = new TransacaoResponseDTO(
                cliente.getLimite(),
                novoSaldo
        );

        return ResponseEntity.ok().body(response);
    }
}
