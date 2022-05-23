package com.rmbank.microstatement.v1.hexagono.dominio;

import com.rmbank.microstatement.v1.hexagono.dominio.utils.Validador;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="conta")
public class Conta {

    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @NotNull
    @Positive
    @Column(name = "numero")
    private Integer numero;

    @Column(name = "ativa")
    private Boolean ativa;

    public void validar() {
        Validador.validar(this);
    }
}
