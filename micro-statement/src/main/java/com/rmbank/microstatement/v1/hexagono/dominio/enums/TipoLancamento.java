package com.rmbank.microstatement.v1.hexagono.dominio.enums;

public enum TipoLancamento {
    DEBITO("D"),
    CREDITO("C");

    public final String label;

    TipoLancamento(String label) {
        this.label = label;
    }
}
