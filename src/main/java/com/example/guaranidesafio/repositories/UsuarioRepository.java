package com.example.guaranidesafio.repositories;

import com.example.guaranidesafio.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
