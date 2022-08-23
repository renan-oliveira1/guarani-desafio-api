package com.example.guaranidesafio.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNaoEncontradoException extends Exception{
    public UsuarioNaoEncontradoException(Long id) {
        super(String.format("Usuario com o id %s não encontrado!", id));
    }
}
