package com.rmbank.microstatement.v1.hexagono.dominio;

import com.rmbank.microstatement.v1.hexagono.dominio.utils.Validador;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="lancamentos")
public class Lancamento {

    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    private Conta conta;

    @NotNull
    @Positive
    @Column(name = "valor")
    private BigDecimal valor;

    @NotNull
    @Column(name = "debito_credito")
    private String debitoCredito;

    @NotNull
    @Column(name = "dthrlancto")
    private LocalDateTime dtHrLancamento;

    @Column(name = "consolidado")
    private Boolean consolidado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_conta_destinatario", referencedColumnName = "id")
    private Conta destinatario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_conta_remetente", referencedColumnName = "id")
    private Conta remetente;

    @Column(name = "descricao")
    private String descricao;

    @NotNull
    @Column(name = "UUID")
    private String uuid;

    public void validar() {
        Validador.validar(this);
    }

}
