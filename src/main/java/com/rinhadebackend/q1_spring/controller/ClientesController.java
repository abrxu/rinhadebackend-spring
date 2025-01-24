package com.rinhadebackend.q1_spring.controller;

import com.rinhadebackend.q1_spring.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    TransacaoService transacaoService;

    @RequestMapping("/{id}/transacao")
    public ResponseEntity realizarTransacao(@PathVariable Integer id, @RequestMapping Integer valor, char tipo, String descricao) {
        transacaoService.realizarTransacao(id, valor, tipo, descricao);
    }

}
