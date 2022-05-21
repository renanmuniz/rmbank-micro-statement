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
public class CadastroDto {

    @JsonIgnore
    private Long id;
    private String nome;
    @JsonIgnore
    private String telefone;
    @JsonIgnore
    private String email;
    private String cpfCnpj;

}
