package com.rinhadebackend.q1_spring.dtos;

import java.sql.Timestamp;

public record SaldoExtratoResponseDTO(Integer total, Timestamp data_extrato, Integer limite) {
}
