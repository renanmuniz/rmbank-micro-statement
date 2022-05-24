package com.rmbank.microstatement.v1.hexagono.dominio;

import com.rmbank.microstatement.v1.hexagono.dominio.utils.Validador;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "cadastro")
public class Cadastro {
    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Column(name = "nome")
    private String nome;

    @NotNull
    @NotEmpty
    @Column(name = "telefone")
    private String telefone;

    @NotNull
    @NotEmpty
    @Column(name = "email")
    private String email;

    @NotNull
    @NotEmpty
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    public void validar() {
        Validador.validar(this);
    }
}
