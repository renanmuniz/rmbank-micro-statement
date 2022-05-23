package com.rmbank.microstatement.v1.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoDto {

    private Long id;
    private ContaDto conta;
    private BigDecimal valor;
    private String debitoCredito;
    private String dtHrLancamento;
    private Boolean consolidado;
    private ContaDto destinatario;
    private ContaDto remetente;
    private String descricao;
    private String uuid;

}
