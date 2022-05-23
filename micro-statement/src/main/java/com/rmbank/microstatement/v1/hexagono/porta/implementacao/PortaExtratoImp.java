package com.rmbank.microstatement.v1.hexagono.porta.implementacao;

import com.rmbank.microstatement.v1.hexagono.dominio.Lancamento;
import com.rmbank.microstatement.v1.hexagono.porta.contrato.PortaExtrato;
import com.rmbank.microstatement.v1.hexagono.processo.contrato.ProcessoExtrato;
import com.rmbank.microstatement.v1.hexagono.processo.implementacao.ProcessoExtratoImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class PortaExtratoImp implements PortaExtrato {

    @Autowired
    ProcessoExtrato processoExtrato;

    /**
     * Contrutor utilizado para injetar classe mock nos testes
     * @param processoExtrato
     */
    public PortaExtratoImp(ProcessoExtratoImp processoExtrato) {
        this.processoExtrato = processoExtrato;
    }

    @Override
    public List<Lancamento> getPorData(Long idConta, LocalDateTime inicio, LocalDateTime fim) {
        log.info("Chamado PortaExtrato.getPorData() - " + idConta + " " + inicio + " " + fim);
        return processoExtrato.getPorData(idConta, inicio, fim);
    }
}
