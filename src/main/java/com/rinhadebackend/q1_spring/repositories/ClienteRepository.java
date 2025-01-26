package com.rinhadebackend.q1_spring.repositories;

import com.rinhadebackend.q1_spring.domain.cliente.Cliente;
import com.rinhadebackend.q1_spring.domain.transacao.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findClienteById(Integer id);

    @Query("SELECT t FROM Transacao t WHERE t.cliente.id = :id")
    List<Transacao> findAllTransacaoById(@Param("id") Integer id);
}
