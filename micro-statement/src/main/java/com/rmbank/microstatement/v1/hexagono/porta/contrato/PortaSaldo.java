package com.rmbank.microstatement.v1.hexagono.porta.contrato;


import com.rmbank.microstatement.v1.hexagono.dominio.Saldo;

public interface PortaSaldo {

    Saldo getPorConta(Long idConta);

}
