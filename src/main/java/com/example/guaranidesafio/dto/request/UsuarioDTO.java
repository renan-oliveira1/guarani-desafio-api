package com.example.guaranidesafio.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
public class UsuarioDTO {

    private String nome;
    private String sobrenome;
    private String email;
    private Boolean ativo;


    public UsuarioDTO(String nome, String sobrenome, String email, Boolean ativo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.ativo = ativo;
    }

}
