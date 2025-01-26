package com.rinhadebackend.q1_spring.domain.cliente;

import com.rinhadebackend.q1_spring.domain.transacao.Transacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "total")
    private Integer total;

    @Column(name = "limite")
    private Integer limite;

    @OneToMany(mappedBy = "cliente")
    private List<Transacao> transacoes;
}
