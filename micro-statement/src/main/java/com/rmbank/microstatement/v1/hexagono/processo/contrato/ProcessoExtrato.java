package com.rmbank.microstatement.v1.hexagono.processo.contrato;

import com.rmbank.microstatement.v1.hexagono.dominio.Lancamento;

import java.time.LocalDateTime;
import java.util.List;

public interface ProcessoExtrato {
    List<Lancamento> getPorData(Long idConta, LocalDateTime inicio, LocalDateTime fim);
}
