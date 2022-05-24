package com.rmbank.microstatement.v1.hexagono.porta.implementacao;

import com.rmbank.microstatement.v1.hexagono.dominio.Saldo;
import com.rmbank.microstatement.v1.hexagono.porta.contrato.PortaSaldo;
import com.rmbank.microstatement.v1.hexagono.processo.contrato.ProcessoSaldo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class PortaSaldoImp implements PortaSaldo {

    @Autowired
    ProcessoSaldo processoSaldo;

    /**
     * Contrutor utilizado para injetar classe mock nos testes
     * @param processoSaldo
     */
    public PortaSaldoImp(ProcessoSaldo processoSaldo) {
        this.processoSaldo = processoSaldo;
    }

    @Override
    public Saldo getPorConta(Long idConta) {
        log.info("Chamado PortaSaldo.getPorConta() - " + idConta);
        return processoSaldo.getPorConta(idConta);
    }
}
