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
    public Long id;

    @NotNull
    @NotEmpty
    @Column(name = "nome")
    public String nome;

    @NotNull
    @NotEmpty
    @Column(name = "telefone")
    public String telefone;

    @NotNull
    @NotEmpty
    @Column(name = "email")
    public String email;

    @NotNull
    @NotEmpty
    @Column(name = "cpf_cnpj")
    public String cpfCnpj;

    public void validar() {
        Validador.validar(this);
    }
}
