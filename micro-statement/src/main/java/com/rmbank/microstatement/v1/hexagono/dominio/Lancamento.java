package com.rmbank.microstatement.v1.hexagono.dominio;

import com.rmbank.microstatement.v1.hexagono.dominio.utils.Validador;
import com.rmbank.microstatement.v1.hexagono.exception.NegocioException;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
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
    @NotEmpty
    @Column(name = "debito_credito")
    private String debitoCredito;

    @NotNull
    @PastOrPresent
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
    @NotEmpty
    @Column(name = "UUID")
    private String uuid;

    public void validar() throws NegocioException {
        Validador.validar(this);
        validarFlagDebitoCredito();
        validarRegraDebitoDestinatarioPreenchido();
    }

    public void validarFlagDebitoCredito() throws NegocioException {
        if(!this.debitoCredito.equals("C") && !this.debitoCredito.equals("D")) {
            throw new NegocioException("Flag de débito/crédito inválida. Use D ou C.");
        }
    }

    public void validarRegraDebitoDestinatarioPreenchido () throws NegocioException {
        if(this.remetente == null && this.destinatario == null) {
            throw new NegocioException("Remetente e Destinatário não devem estar vazios simultâneamente.");
        }
        if(this.remetente != null && this.destinatario != null) {
            throw new NegocioException("Remetente e Destinatário não devem estar preenchidos simultâneamente.");
        }
        if(this.debitoCredito.equals("C") && this.remetente == null) {
            throw new NegocioException("Remetente deve estar preenchido em caso de crédito.");
        }
        if(this.debitoCredito.equals("D") && this.destinatario == null) {
            throw new NegocioException("Destinatário deve estar preenchido em caso de débito.");
        }
    }

}
