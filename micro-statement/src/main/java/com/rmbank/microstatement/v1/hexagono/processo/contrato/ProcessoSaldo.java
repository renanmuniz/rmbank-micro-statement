package com.rmbank.microstatement.v1.hexagono.processo.contrato;

import com.rmbank.microstatement.v1.hexagono.dominio.Saldo;

public interface ProcessoSaldo {
    Saldo getPorConta(Long idConta);
}
