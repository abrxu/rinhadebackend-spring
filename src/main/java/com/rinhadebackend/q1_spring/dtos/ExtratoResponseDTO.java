package com.rinhadebackend.q1_spring.dtos;

import java.util.List;

public record ExtratoResponseDTO(SaldoExtratoResponseDTO saldoExtratoResponseDTO, List<TransacaoExtratoResponseDTO> transacaoExtratoResponseDTOList) {
}
