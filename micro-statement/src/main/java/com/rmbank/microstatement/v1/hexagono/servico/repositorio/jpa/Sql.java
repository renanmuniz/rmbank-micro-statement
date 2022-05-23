package com.rmbank.microstatement.v1.hexagono.servico.repositorio.jpa;

public class Sql {
    public static final String SELECT_LANCTO_POR_CONTA_E_DATA =
            "select * from lancamentos " +
            "where conta_id = ? " +
            "and dthrlancto between ? and ?";
}
