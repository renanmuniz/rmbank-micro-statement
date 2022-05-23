package com.rmbank.microstatement.v1.hexagono.processo.implementacao;

import com.rmbank.microstatement.v1.hexagono.dominio.Lancamento;
import com.rmbank.microstatement.v1.hexagono.processo.contrato.ProcessoExtrato;
import com.rmbank.microstatement.v1.hexagono.servico.repositorio.jpa.LancamentoRepository;
import com.rmbank.microstatement.v1.hexagono.servico.repositorio.mock.LancamentoRepositoryMock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ProcessoExtratoImp implements ProcessoExtrato {

    @Autowired
    LancamentoRepository lancamentoRepository;

    /**
     * Contrutor utilizado para injetar classe mock nos testes
     * @param lancamentoRepository
     */
    public ProcessoExtratoImp(LancamentoRepository lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    @Override
    public List<Lancamento> getPorData(Long idConta, LocalDateTime inicio, LocalDateTime fim) {
        log.info("Chamado o ProcessoExtrato.getPorData() - " + idConta + " " + inicio + " " + fim);
        List<Lancamento> lancamentos = lancamentoRepository.getPorData(idConta, inicio, fim);
        if (lancamentos.isEmpty()) {
            log.info("Sem lancamentos para o periodo informado.");
        }
        for(Lancamento lancamento : lancamentos) {
            log.info("Lancamento retornado: " + lancamento.toString());
        }
        return lancamentos;
    }
}
