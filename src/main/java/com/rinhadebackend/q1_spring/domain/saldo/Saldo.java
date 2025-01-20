package com.rinhadebackend.q1_spring.domain.saldo;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "saldo")
public class Saldo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "total")
    private Integer total;

    @Column(name = "data_extrato")
    private Timestamp data_extrato;

    @Column(name = "limite")
    private Integer limite;

}
