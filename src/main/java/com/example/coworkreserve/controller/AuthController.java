package com.example.coworkreserve.controller;

import com.example.coworkreserve.model.Usuario;
import com.example.coworkreserve.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); // Instancia de BCrypt
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        System.out.println("Email recibido: " + loginRequest.getEmail());
        System.out.println("Contraseña recibida: " + loginRequest.getPassword());

        Optional<Usuario> usuario = usuarioRepository.findByEmail(loginRequest.getEmail());

        if (usuario.isPresent()) {
            System.out.println("Hash en la base de datos: " + usuario.get().getPasswordHash());
            if (passwordEncoder.matches(loginRequest.getPassword(), usuario.get().getPasswordHash())) {
                String token = "token-generado"; // Generar un token real si es necesario
                return ResponseEntity.ok(new LoginResponse(token));
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }


    public static class LoginRequest {
        private String email;
        private String password;

        // Getters y setters
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class LoginResponse {
        private String token;

        public LoginResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }
}
