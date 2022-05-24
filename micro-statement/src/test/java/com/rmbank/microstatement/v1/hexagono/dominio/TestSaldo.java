package com.rmbank.microstatement.v1.hexagono.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestSaldo {

    public static Saldo fabricarValido() {
        return new Saldo(
                1L,
                TestConta.fabricarValido(),
                BigDecimal.valueOf(1000.0),
                LocalDateTime.now()
        );
    }

    @Test
    void testeIdNulo() {
        try {
            Saldo saldo = fabricarValido();
            saldo.setId(null);
            saldo.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeContaNulo() {
        try {
            Saldo saldo = fabricarValido();
            saldo.setConta(null);
            saldo.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeValorNulo() {
        try {
            Saldo saldo = fabricarValido();
            saldo.setValor(null);
            saldo.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeDtHrLanctoNulo() {
        try {
            Saldo saldo = fabricarValido();
            saldo.setDtHrSaldo(null);
            saldo.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeDtHrLanctoFuturo() {
        try {
            Saldo saldo = fabricarValido();
            saldo.setDtHrSaldo(LocalDateTime.now().plusDays(1));
            saldo.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeSucesso() {
        try {
            Saldo saldo = fabricarValido();
            saldo.validar();
        } catch (Exception e) {
            Assertions.fail("Não deveria dar erro em saldo válido - " + e.getMessage());
        }
    }

}
