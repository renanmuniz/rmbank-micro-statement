package com.rmbank.microstatement.v1.hexagono.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUsuario {

    public static Usuario fabricarValido() {
        return new Usuario(
                1L,
                "usuario",
                "1234senha",
                TestCadastro.fabricarValido()
        );
    }

    @Test
    void testeIdNulo() {
        try {
            Usuario usuario = fabricarValido();
            usuario.setId(null);
            usuario.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeNomeNulo() {
        try {
            Usuario usuario = fabricarValido();
            usuario.setNome(null);
            usuario.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeNomeVazio() {
        try {
            Usuario usuario = fabricarValido();
            usuario.setNome("");
            usuario.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeSenhaNulo() {
        try {
            Usuario usuario = fabricarValido();
            usuario.setSenha(null);
            usuario.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeSenhaVazio() {
        try {
            Usuario usuario = fabricarValido();
            usuario.setSenha("");
            usuario.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeCadastroVazio() {
        try {
            Usuario usuario = fabricarValido();
            usuario.setCadastro(null);
            usuario.validar();
            Assertions.fail("Deveria dar erro de validação.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testeSucesso() {
        try {
            Usuario usuario = fabricarValido();
            usuario.validar();
        } catch (Exception e) {
            Assertions.fail("Não deveria dar erro em cadastro válido - " + e.getMessage());
        }
    }

}
