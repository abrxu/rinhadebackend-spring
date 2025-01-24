package com.rinhadebackend.q1_spring.dtos;

import java.sql.Timestamp;

public record TransacaoExtratoResponseDTO(Integer valor, char tipo, String descricao, Timestamp realizado_em) {
}
