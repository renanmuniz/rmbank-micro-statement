package com.rmbank.microstatement.v1.rest.contrato;

import com.rmbank.microstatement.v1.hexagono.exception.NegocioException;
import com.rmbank.microstatement.v1.rest.dto.LancamentoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExtratoRest {
    ResponseEntity<List<LancamentoDto>> getPorData(Long idConta, String inicio, String fim) throws NegocioException;
}
