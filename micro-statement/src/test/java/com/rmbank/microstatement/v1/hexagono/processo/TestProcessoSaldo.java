package com.rmbank.microstatement.v1.hexagono.processo;

import com.rmbank.microstatement.v1.hexagono.dominio.Saldo;
import com.rmbank.microstatement.v1.hexagono.processo.implementacao.ProcessoSaldoImp;
import com.rmbank.microstatement.v1.hexagono.servico.repositorio.mock.SaldoRepositoryMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class TestProcessoSaldo {

    ProcessoSaldoImp processoSaldoImp =
            new ProcessoSaldoImp(new SaldoRepositoryMock());

    @Test
    void testaFluxoOk() {
        Saldo saldo = processoSaldoImp.getPorConta(1L);
        Assertions.assertEquals(BigDecimal.valueOf(1000), saldo.getValor());
    }

}
