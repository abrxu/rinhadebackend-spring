package com.rinhadebackend.q1_spring.dtos;

import java.time.Instant;

public record TransacoesResponseDTO(Integer valor, String tipo, String descricao, Instant realizadaEm) {
}
