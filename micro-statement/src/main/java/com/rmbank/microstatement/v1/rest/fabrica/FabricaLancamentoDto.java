package com.rmbank.microstatement.v1.rest.fabrica;

import com.rmbank.microstatement.v1.hexagono.dominio.Cadastro;
import com.rmbank.microstatement.v1.hexagono.dominio.Conta;
import com.rmbank.microstatement.v1.hexagono.dominio.Lancamento;
import com.rmbank.microstatement.v1.hexagono.dominio.Usuario;
import com.rmbank.microstatement.v1.rest.dto.CadastroDto;
import com.rmbank.microstatement.v1.rest.dto.ContaDto;
import com.rmbank.microstatement.v1.rest.dto.LancamentoDto;
import com.rmbank.microstatement.v1.rest.dto.UsuarioDto;
import lombok.extern.slf4j.Slf4j;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class FabricaLancamentoDto {

    public static LancamentoDto fabricar(Lancamento lancamento) {

        return new LancamentoDto(
                lancamento.getId(),
                fabricarContaDto(lancamento.getConta()),
                lancamento.getValor(),
                lancamento.getDebitoCredito(),
                formatarDataHora(lancamento.getDtHrLancamento().toString()),
                lancamento.getConsolidado(),
                fabricarContaDto(lancamento.getDestinatario()),
                fabricarContaDto(lancamento.getRemetente()),
                lancamento.getDescricao(),
                lancamento.getUuid());
    }

    private static ContaDto fabricarContaDto(Conta conta) {
        if(conta != null) {
            return new ContaDto(
                    conta.getId(),
                    conta.getNumero(),
                    conta.getAtiva(),
                    fabricarUsuarioDto(conta.getUsuario()));
        }
        return null;
    }

    private static UsuarioDto fabricarUsuarioDto(Usuario usuario) {
        if(usuario != null) {
            return new UsuarioDto(
                    usuario.getId(),
                    usuario.getNome(),
                    fabricarCadastroDto(usuario.getCadastro()));
        }
        return null;
    }

    private static CadastroDto fabricarCadastroDto(Cadastro cadastro) {
        if(cadastro != null) {
            return new CadastroDto(
                    cadastro.getId(),
                    cadastro.getNome(),
                    cadastro.getTelefone(),
                    cadastro.getEmail(),
                    formatCPF(cadastro.getCpfCnpj()));
        }
        return null;
    }

    private static String formatCPF(String cpf) {
        try {
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            mask.setValueContainsLiteralCharacters(false);
            String formatado = mask.valueToString(cpf);
            formatado = "***" + formatado.substring(3,12) + "**";
            return formatado;
        } catch (ParseException ex) {
            log.error(ex.getMessage());
        }
        return cpf;
    }

    private static String formatarDataHora(String dthr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            LocalDateTime localDateInicio = LocalDateTime.parse(dthr, formatter);
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            return localDateInicio.format(formatter);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return dthr;
    }

    // Sonar rule: java:S1118
    private FabricaLancamentoDto() {
    }
}
