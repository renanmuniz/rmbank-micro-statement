package com.rmbank.microstatement.v1.hexagono.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCadastro {

    public static Cadastro fabricarValido() {
        return new Cadastro(
                1L,
                "Joao teste cadastro",
                "11912345678",
                "joao_teste@email.com",
                "98501737003"
        );
    }

    @Test
    void testeIdNulo() {
        try {
            Cadastro cadastro = fabricarValido();
            cadastro.setId(null);
            cadastro.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeNomeNulo() {
        try {
            Cadastro cadastro = fabricarValido();
            cadastro.setNome(null);
            cadastro.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeNomeVazio() {
        try {
            Cadastro cadastro = fabricarValido();
            cadastro.setNome("");
            cadastro.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeTelefoneNulo() {
        try {
            Cadastro cadastro = fabricarValido();
            cadastro.setTelefone(null);
            cadastro.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeTelefoneVazio() {
        try {
            Cadastro cadastro = fabricarValido();
            cadastro.setTelefone("");
            cadastro.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeEmailNulo() {
        try {
            Cadastro cadastro = fabricarValido();
            cadastro.setEmail(null);
            cadastro.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeEmailVazio() {
        try {
            Cadastro cadastro = fabricarValido();
            cadastro.setEmail("");
            cadastro.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeCpfCnpjNulo() {
        try {
            Cadastro cadastro = fabricarValido();
            cadastro.setCpfCnpj(null);
            cadastro.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeCpfCnpjVazio() {
        try {
            Cadastro cadastro = fabricarValido();
            cadastro.setCpfCnpj("");
            cadastro.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeSucesso() {
        try {
            Cadastro cadastro = fabricarValido();
            cadastro.validar();
        } catch (Exception e) {
            Assertions.fail("Não deveria dar erro em cadastro válido - " + e.getMessage());
        }
    }

}
