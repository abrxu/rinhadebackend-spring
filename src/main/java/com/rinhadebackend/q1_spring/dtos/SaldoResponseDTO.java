package com.rinhadebackend.q1_spring.dtos;

import java.time.Instant;

public record SaldoResponseDTO(Integer total, Instant dataExtrato, Integer limite) {
}
