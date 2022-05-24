package com.rmbank.microstatement.v1.hexagono.porta;

import com.rmbank.microstatement.v1.hexagono.dominio.Saldo;
import com.rmbank.microstatement.v1.hexagono.porta.contrato.PortaSaldo;
import com.rmbank.microstatement.v1.hexagono.porta.implementacao.PortaSaldoImp;
import com.rmbank.microstatement.v1.hexagono.processo.implementacao.ProcessoSaldoImp;
import com.rmbank.microstatement.v1.hexagono.servico.repositorio.mock.SaldoRepositoryMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class TestPortaSaldo {

    PortaSaldo porta = new PortaSaldoImp(new ProcessoSaldoImp(new SaldoRepositoryMock()));

    @Test
    void testaFluxoOk() {
        Saldo saldo = porta.getPorConta(1L);
        Assertions.assertEquals(BigDecimal.valueOf(1000), saldo.getValor());
    }

}
