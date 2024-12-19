package com.example.coworkreserve.repository;

import com.example.coworkreserve.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
