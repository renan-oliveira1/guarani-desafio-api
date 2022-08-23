package com.example.guaranidesafio.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Campo nome não pode ser nulo")
    @NotEmpty(message = "Campo nome não pode ser vazio")
    private String nome;

    @Column(nullable = false)
    @NotNull(message = "Campo sobrenome não pode ser nulo")
    @NotEmpty(message = "Campo sobrenome não pode ser vazio")
    private String sobrenome;

    @Column(nullable = false, unique = true)
    @Email(message = "Campo precisa ser um email")
    private String email;

    private Boolean ativo;

    @Column(nullable = false)
    @NotNull(message = "Campo usuario não pode ser nulo")
    @NotEmpty(message = "Campo usuario não pode ser vazio")
    private String usuario;

    @Column(nullable = false)
    @NotNull(message = "Campo senha não pode ser nulo")
    @NotEmpty(message = "Campo senha não pode ser vazio")
    private String senha;


}
