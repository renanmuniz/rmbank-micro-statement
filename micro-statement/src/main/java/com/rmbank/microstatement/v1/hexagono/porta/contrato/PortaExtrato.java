package com.rmbank.microstatement.v1.hexagono.porta.contrato;


import com.rmbank.microstatement.v1.hexagono.dominio.Lancamento;

import java.time.LocalDateTime;
import java.util.List;

public interface PortaExtrato {

    List<Lancamento> getPorData(Long idConta, LocalDateTime inicio, LocalDateTime fim);

}
