package com.rinhadebackend.q1_spring.domain.cliente;

import com.rinhadebackend.q1_spring.domain.transacao.Transacao;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    public Cliente() {}

    public Cliente(Integer id, Integer total, Integer limite, List<Transacao> transacoes) {
        this.id = id;
        this.total = total;
        this.limite = limite;
        this.transacoes = transacoes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "total")
    private Integer total;

    @Column(name = "limite")
    private Integer limite;

    @OneToMany(mappedBy = "cliente")
    private List<Transacao> transacoes;

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
