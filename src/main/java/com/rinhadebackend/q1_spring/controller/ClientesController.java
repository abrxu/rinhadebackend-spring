package com.rinhadebackend.q1_spring.controller;
import com.rinhadebackend.q1_spring.dtos.ExtratoResponseDTO;
import com.rinhadebackend.q1_spring.dtos.TransacaoRequestDTO;
import com.rinhadebackend.q1_spring.dtos.TransacaoResponseDTO;
import com.rinhadebackend.q1_spring.exceptions.ClienteNotFoundException;
import com.rinhadebackend.q1_spring.exceptions.InvalidTransactionException;
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
    public ResponseEntity<TransacaoResponseDTO> realizarTransacao(@PathVariable Integer id, @RequestBody TransacaoRequestDTO transacaoRequestDTO) {
        try {
            var response = transacaoService.realizarTransacao(id, transacaoRequestDTO);
            return ResponseEntity.ok(response);
        } catch (ClienteNotFoundException cliExc) {
            return ResponseEntity.notFound().build();
        } catch (InvalidTransactionException invTransExc) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @GetMapping("{id}/extrato")
    public ResponseEntity<ExtratoResponseDTO> visualizarExtrato(@PathVariable Integer id) {
        try {
            var response = extratoService.visualizarExtrato(id);
            return ResponseEntity.ok(response);
        }  catch (ClienteNotFoundException cliExc) {
            return ResponseEntity.notFound().build();
        }
    }


}
