package com.rmbank.microstatement.v1.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDto {

    @JsonIgnore
    private Long id;
    @JsonIgnore
    private String nome;
    private CadastroDto cadastro;

}
