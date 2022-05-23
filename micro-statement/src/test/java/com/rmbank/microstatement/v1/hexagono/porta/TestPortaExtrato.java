package com.rmbank.microstatement.v1.hexagono.porta;

import com.rmbank.microstatement.v1.hexagono.dominio.Lancamento;
import com.rmbank.microstatement.v1.hexagono.porta.contrato.PortaExtrato;
import com.rmbank.microstatement.v1.hexagono.porta.implementacao.PortaExtratoImp;
import com.rmbank.microstatement.v1.hexagono.processo.implementacao.ProcessoExtratoImp;
import com.rmbank.microstatement.v1.hexagono.servico.repositorio.mock.LancamentoRepositoryMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

class TestPortaExtrato {

    PortaExtrato porta = new PortaExtratoImp(new ProcessoExtratoImp(new LancamentoRepositoryMock()));

    @Test
    void testaFluxoOk() {
        List<Lancamento> lista;
        lista = porta.getPorData(1L, LocalDateTime.now(), LocalDateTime.now().plusDays(1));
        Assertions.assertEquals(5, lista.size());
    }

}
