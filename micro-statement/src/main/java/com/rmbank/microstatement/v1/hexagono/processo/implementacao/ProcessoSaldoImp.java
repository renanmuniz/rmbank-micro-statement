package com.rmbank.microstatement.v1.hexagono.processo.implementacao;

import com.rmbank.microstatement.v1.hexagono.dominio.Saldo;
import com.rmbank.microstatement.v1.hexagono.processo.contrato.ProcessoSaldo;
import com.rmbank.microstatement.v1.hexagono.servico.repositorio.jpa.SaldoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Slf4j
public class ProcessoSaldoImp implements ProcessoSaldo {

    @Autowired
    SaldoRepository saldoRepository;

    /**
     * Contrutor utilizado para injetar classe mock nos testes
     * @param saldoRepository
     */
    public ProcessoSaldoImp(SaldoRepository saldoRepository) {
        this.saldoRepository = saldoRepository;
    }

    @Override
    public Saldo getPorConta(Long idConta) {
        log.info("Chamado o ProcessoSaldo.getPorConta() - " + idConta);
        Optional<Saldo> saldoOpt = saldoRepository.getSaldo(idConta);
        if(saldoOpt.isPresent()) {
            log.info("Retornando saldo para conta de id {}.", idConta);
            return saldoOpt.get();
        } else {
            log.info("Saldo para conta de id {} não encontrado.", idConta);
            return null;
        }
    }
}
