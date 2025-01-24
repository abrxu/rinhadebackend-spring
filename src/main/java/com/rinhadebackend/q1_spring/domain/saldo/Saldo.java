package com.rinhadebackend.q1_spring.domain.saldo;

import com.rinhadebackend.q1_spring.domain.cliente.Cliente;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "saldo")
public class Saldo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    @Column(name = "total")
    private Integer total;

    @Column(name = "data_extrato")
    private Timestamp atualizadoEm;

    @Column(name = "limite")
    private Integer limite;

}
