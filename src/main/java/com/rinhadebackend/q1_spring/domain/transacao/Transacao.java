package com.rinhadebackend.q1_spring.domain.transacao;

import com.rinhadebackend.q1_spring.domain.cliente.Cliente;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "transacao")
public class Transacao {

    public Transacao() {}

    public Transacao(Cliente cliente, Integer valor, String tipo, String descricao, Instant realizadaEm) {
        this.cliente = cliente;
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
    private Cliente cliente;

    @Column(name = "valor", nullable = false)
    private Integer valor;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "realizada_em", nullable = false)
    private Instant realizadaEm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Instant getRealizadaEm() {
        return realizadaEm;
    }

    public void setRealizadaEm(Instant realizadaEm) {
        this.realizadaEm = realizadaEm;
    }
}
