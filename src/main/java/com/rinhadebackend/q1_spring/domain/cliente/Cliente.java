package com.rinhadebackend.q1_spring.domain.cliente;

import com.rinhadebackend.q1_spring.domain.saldo.Saldo;
import com.rinhadebackend.q1_spring.domain.transacao.Transacao;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "saldo_cliente", referencedColumnName = "id")
    private Saldo saldo;

    @OneToMany(mappedBy = "cliente")
    private List<Transacao> transacoes;

}
