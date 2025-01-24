package com.rinhadebackend.q1_spring.repositories;

import com.rinhadebackend.q1_spring.domain.transacao.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {
}
