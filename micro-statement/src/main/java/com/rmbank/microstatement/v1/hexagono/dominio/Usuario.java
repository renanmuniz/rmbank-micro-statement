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
@Table(name = "usuario")
public class Usuario {
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
    @Column(name = "senha")
    public String senha;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cadastro", referencedColumnName = "id")
    private Cadastro cadastro;

    public void validar() {
        Validador.validar(this);
    }
}
