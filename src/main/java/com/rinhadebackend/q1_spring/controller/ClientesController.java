package com.rinhadebackend.q1_spring.controller;
import com.rinhadebackend.q1_spring.dtos.TransacaoRequestDTO;
import com.rinhadebackend.q1_spring.service.ExtratoService;
import com.rinhadebackend.q1_spring.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    TransacaoService transacaoService;

    @Autowired
    ExtratoService extratoService;

    @PostMapping("/{id}/transacoes")
    public ResponseEntity realizarTransacao(@PathVariable Integer id, @RequestBody TransacaoRequestDTO transacaoRequestDTO) {
        return transacaoService.realizarTransacao(id, transacaoRequestDTO);
    }

    @GetMapping("{id}/extrato")
    public ResponseEntity visualizarExtrato(@PathVariable Integer id) {
        return extratoService.visualizarExtrato(id);
    }


}
