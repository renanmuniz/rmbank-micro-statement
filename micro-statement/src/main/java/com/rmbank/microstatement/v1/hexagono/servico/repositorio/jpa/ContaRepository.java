package com.rmbank.microstatement.v1.hexagono.servico.repositorio.jpa;

import com.rmbank.microstatement.v1.hexagono.dominio.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    Conta getOne(Long id);

}
