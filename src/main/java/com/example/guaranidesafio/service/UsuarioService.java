package com.example.guaranidesafio.service;

import com.example.guaranidesafio.dto.request.UsuarioDTO;
import com.example.guaranidesafio.dto.response.RespostaDTO;
import com.example.guaranidesafio.entities.Usuario;
import com.example.guaranidesafio.repositories.UsuarioRepository;
import com.example.guaranidesafio.util.exception.UsuarioNaoEncontradoException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public RespostaDTO insert(Usuario usuario){
        usuarioRepository.save(usuario);

        return criarMensagemRespostaDto("Usuário cadastrado com sucesso");
    }

    public UsuarioDTO findById(Long id) throws UsuarioNaoEncontradoException {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));

        return toDto(usuario);
    }


    public List<UsuarioDTO> findAll(){
        return usuarioRepository.findAll().stream().map(usuario -> new UsuarioDTO(usuario.getNome(),
                usuario.getSobrenome(), usuario.getEmail(),
                usuario.getAtivo())
        ).collect(Collectors.toList());
    }

    public void delete(Long id) throws UsuarioNaoEncontradoException {
        usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
        usuarioRepository.deleteById(id);
    }

    public RespostaDTO updateEmailOrUser(Long id, Usuario usuario) throws UsuarioNaoEncontradoException {
        Usuario usuarioBanco = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));

        usuarioBanco.setEmail(usuario.getEmail());
        usuarioBanco.setUsuario(usuario.getUsuario());

        usuarioRepository.save(usuarioBanco);

        return criarMensagemRespostaDto("Usuário atualizado com sucesso");
    }


    private UsuarioDTO toDto(Usuario usuario){

        return new UsuarioDTO(
                usuario.getNome(), usuario.getSobrenome(),
                usuario.getEmail(), usuario.getAtivo());
    }

    private RespostaDTO criarMensagemRespostaDto(String string){
        return RespostaDTO.builder()
                .message(string).build();
    }

}
