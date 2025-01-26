package com.rinhadebackend.q1_spring.dtos;

import java.util.List;

public record ExtratoResponseDTO(SaldoResponseDTO saldo, List<TransacoesResponseDTO> ultimas_transacoes) {

}
