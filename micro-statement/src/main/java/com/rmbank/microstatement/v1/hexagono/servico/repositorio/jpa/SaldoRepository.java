package com.rmbank.microstatement.v1.hexagono.servico.repositorio.jpa;

import com.rmbank.microstatement.v1.hexagono.dominio.Saldo;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Profile("prod")
public interface SaldoRepository extends JpaRepository<Saldo, Long> {

    @Query(value = Sql.SELECT_SALDO_POR_CONTA, nativeQuery = true)
    Optional<Saldo> getSaldo(Long idConta);

}
