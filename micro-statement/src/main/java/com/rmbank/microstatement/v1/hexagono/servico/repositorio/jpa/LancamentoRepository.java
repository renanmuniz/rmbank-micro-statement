package com.rmbank.microstatement.v1.hexagono.servico.repositorio.jpa;

import com.rmbank.microstatement.v1.hexagono.dominio.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    Lancamento getOne(Long id);

    @Query(value = Sql.SELECT_LANCTO_POR_CONTA_E_DATA, nativeQuery = true)
    List<Lancamento> getPorData(Long idConta, LocalDateTime inicio, LocalDateTime fim);

}
