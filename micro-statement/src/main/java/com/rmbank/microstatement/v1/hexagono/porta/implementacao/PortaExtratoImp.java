package com.rmbank.microstatement.v1.hexagono.porta.implementacao;

import com.rmbank.microstatement.v1.hexagono.dominio.Lancamento;
import com.rmbank.microstatement.v1.hexagono.porta.contrato.PortaExtrato;
import com.rmbank.microstatement.v1.hexagono.processo.contrato.ProcessoExtrato;
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

    @Override
    public List<Lancamento> getPorData(Long idConta, LocalDateTime inicio, LocalDateTime fim) {
        log.info("Chamado PortaExtrato.getPorData() - " + idConta + " " + inicio + " " + fim);
        return processoExtrato.getPorData(idConta, inicio, fim);
    }
}
