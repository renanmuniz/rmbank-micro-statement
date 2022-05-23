package com.rmbank.microstatement.v1.hexagono.processo;

import com.rmbank.microstatement.v1.hexagono.dominio.Lancamento;
import com.rmbank.microstatement.v1.hexagono.processo.implementacao.ProcessoExtratoImp;
import com.rmbank.microstatement.v1.hexagono.servico.repositorio.mock.LancamentoRepositoryMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

class TestProcessoExtrato {

    ProcessoExtratoImp processoExtratoImp =
            new ProcessoExtratoImp(new LancamentoRepositoryMock());

    @Test
    void testaFluxoOk() {
        List<Lancamento> lista;
        lista = processoExtratoImp.getPorData(1L, LocalDateTime.now(), LocalDateTime.now().plusDays(1));
        Assertions.assertEquals(5, lista.size());
    }

}
