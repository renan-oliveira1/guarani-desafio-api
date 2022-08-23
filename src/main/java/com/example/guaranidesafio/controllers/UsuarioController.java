package com.example.guaranidesafio.controllers;

import com.example.guaranidesafio.dto.request.UsuarioDTO;
import com.example.guaranidesafio.dto.response.RespostaDTO;
import com.example.guaranidesafio.entities.Usuario;
import com.example.guaranidesafio.service.UsuarioService;
import com.example.guaranidesafio.util.exception.UsuarioNaoEncontradoException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespostaDTO insert(@RequestBody @Valid Usuario usuario){
        return usuarioService.insert(usuario);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO findById(@PathVariable Long id) throws UsuarioNaoEncontradoException {
        return usuarioService.findById(id);
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDTO> findAll() {
        return usuarioService.findAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public RespostaDTO update(@PathVariable Long id, @RequestBody @Valid Usuario usuario) throws UsuarioNaoEncontradoException {
        return usuarioService.updateEmailOrUser(id, usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws UsuarioNaoEncontradoException {
        usuarioService.delete(id);
    }

}
