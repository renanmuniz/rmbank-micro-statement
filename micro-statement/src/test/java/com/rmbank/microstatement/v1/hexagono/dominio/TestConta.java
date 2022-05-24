package com.rmbank.microstatement.v1.hexagono.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestConta {

    public static Conta fabricarValido() {
        return new Conta(
                1L,
                TestUsuario.fabricarValido(),
                1234,
                true
        );
    }

    @Test
    void testeIdNulo() {
        try {
            Conta conta = fabricarValido();
            conta.setId(null);
            conta.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeUsuarioNulo() {
        try {
            Conta conta = fabricarValido();
            conta.setUsuario(null);
            conta.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeNumeroNulo() {
        try {
            Conta conta = fabricarValido();
            conta.setNumero(null);
            conta.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeNumeroZero() {
        try {
            Conta conta = fabricarValido();
            conta.setNumero(0);
            conta.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeNumeroNegativo() {
        try {
            Conta conta = fabricarValido();
            conta.setNumero(-1);
            conta.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeSucesso() {
        try {
            Conta conta = fabricarValido();
            conta.validar();
        } catch (Exception e) {
            Assertions.fail("Não deveria dar erro em cadastro válido - " + e.getMessage());
        }
    }

}
