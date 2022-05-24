package com.rmbank.microstatement.v1.hexagono.dominio;

import com.rmbank.microstatement.v1.hexagono.dominio.enums.TipoLancamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TestLancamento {

    public static Lancamento fabricarValido() {
        return new Lancamento(
                1L,
                TestConta.fabricarValido(),
                BigDecimal.valueOf(100L),
                TipoLancamento.DEBITO.label,
                LocalDateTime.now(),
                false,
                TestConta.fabricarValido(),
                null,
                "lancamento teste",
                UUID.randomUUID().toString()
        );
    }

    @Test
    void testeIdNulo() {
        try {
            Lancamento lancamento = fabricarValido();
            lancamento.setId(null);
            lancamento.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeContaNulo() {
        try {
            Lancamento lancamento = fabricarValido();
            lancamento.setConta(null);
            lancamento.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeValorNulo() {
        try {
            Lancamento lancamento = fabricarValido();
            lancamento.setValor(null);
            lancamento.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeValorZero() {
        try {
            Lancamento lancamento = fabricarValido();
            lancamento.setValor(BigDecimal.valueOf(0));
            lancamento.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeValorNegativo() {
        try {
            Lancamento lancamento = fabricarValido();
            lancamento.setValor(BigDecimal.valueOf(-10));
            lancamento.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeDebitoCreditoVazio() {
        try {
            Lancamento lancamento = fabricarValido();
            lancamento.setDebitoCredito("");
            lancamento.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeDebitoCreditoNulo() {
        try {
            Lancamento lancamento = fabricarValido();
            lancamento.setDebitoCredito(null);
            lancamento.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeDebitoCreditoInvalido() {
        try {
            Lancamento lancamento = fabricarValido();
            lancamento.setDebitoCredito("X");
            lancamento.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeDtHrLanctoNulo() {
        try {
            Lancamento lancamento = fabricarValido();
            lancamento.setDtHrLancamento(null);
            lancamento.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeRegraCreditoRemetentePreenchido1() {
        try {
            Lancamento lancamento = fabricarValido();
            lancamento.setDestinatario(null);
            lancamento.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeRegraCreditoRemetentePreenchido2() {
        try {
            Lancamento lancamento = fabricarValido();
            lancamento.setDebitoCredito(TipoLancamento.CREDITO.label);
            lancamento.setRemetente(null);
            lancamento.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeRegraDebitoDestinatarioPreenchido3() {
        try {
            Lancamento lancamento = fabricarValido();
            lancamento.setRemetente(TestConta.fabricarValido());
            lancamento.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeRegraDebitoDestinatarioPreenchido4() {
        try {
            Lancamento lancamento = fabricarValido();
            lancamento.setDestinatario(null);
            lancamento.setRemetente(null);
            lancamento.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeUUIDNulo() {
        try {
            Lancamento lancamento = fabricarValido();
            lancamento.setUuid(null);
            lancamento.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeUUIDVazio() {
        try {
            Lancamento lancamento = fabricarValido();
            lancamento.setUuid("");
            lancamento.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeSucesso() {
        try {
            Lancamento lancamento = fabricarValido();
            lancamento.validar();
        } catch (Exception e) {
            Assertions.fail("Não deveria dar erro em cadastro válido - " + e.getMessage());
        }
    }

}
