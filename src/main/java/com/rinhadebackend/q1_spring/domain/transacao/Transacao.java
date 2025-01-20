package com.rinhadebackend.q1_spring.domain.transacao;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "transacao")
public class Transacao {

    public Transacao() {}

    public Transacao(Integer idCliente, Integer valor, char tipo, String descricao, Timestamp realizadaEm) {
        this.idCliente = idCliente;
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
        this.realizadaEm = realizadaEm;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_cliente", nullable = false)
    private Integer idCliente;

    @Column(name = "valor")
    private Integer valor;

    @Column(name = "tipo")
    private char tipo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "realizada_em")
    private Timestamp realizadaEm;

    public Integer getId() {
        return id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Timestamp getRealizadaEm() {
        return realizadaEm;
    }

    public void setRealizadaEm(Timestamp realizadaEm) {
        this.realizadaEm = realizadaEm;
    }
}
