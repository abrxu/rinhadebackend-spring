package com.rinhadebackend.q1_spring.service;

import com.rinhadebackend.q1_spring.dtos.TransacaoResponseDTO;
import com.rinhadebackend.q1_spring.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    @Autowired
    TransacaoRepository transacaoRepository;

    public TransacaoResponseDTO realizarTransacao(Integer id, Integer valor, char tipo, String descricao) {
        // ...
    }

}
