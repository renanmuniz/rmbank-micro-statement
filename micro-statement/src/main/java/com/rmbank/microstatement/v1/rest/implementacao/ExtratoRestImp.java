package com.rmbank.microstatement.v1.rest.implementacao;

import com.rmbank.microstatement.v1.hexagono.dominio.Lancamento;
import com.rmbank.microstatement.v1.hexagono.porta.contrato.PortaExtrato;
import com.rmbank.microstatement.v1.rest.contrato.ExtratoRest;
import com.rmbank.microstatement.v1.rest.dto.LancamentoDto;
import com.rmbank.microstatement.v1.rest.fabrica.FabricaLancamentoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/extrato")
public class ExtratoRestImp implements ExtratoRest {

    @Autowired
    PortaExtrato portaExtrato;

    @GetMapping
    public ResponseEntity<List<LancamentoDto>> getPorData(Long idConta, String inicio, String fim) {
        log.info("Chamada GET em /extrato com os dados: " + idConta + " " + inicio + " " + fim);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateInicio = LocalDateTime.parse(inicio, formatter);
        LocalDateTime localDatefim = LocalDateTime.parse(fim, formatter);
        List<Lancamento> lancamentos = portaExtrato.getPorData(idConta, localDateInicio, localDatefim);
        List<LancamentoDto> lancamentosDto = new ArrayList<>();
        for (Lancamento lancamento : lancamentos) {
            lancamentosDto.add(FabricaLancamentoDto.fabricar(lancamento));
        }
        return ResponseEntity.ok(lancamentosDto);
    }


}
