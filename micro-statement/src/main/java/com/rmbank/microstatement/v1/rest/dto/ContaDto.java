package com.rmbank.microstatement.v1.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaDto {

    @JsonIgnore
    private Long id;
    private Integer numero;
    @JsonIgnore
    private Boolean ativa;
    private UsuarioDto usuario;

}
