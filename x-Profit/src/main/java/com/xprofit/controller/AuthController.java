package com.xprofit.controller;

import com.xprofit.config.JwtUtil;
import com.xprofit.model.entity.Usuario;
import com.xprofit.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        Optional<Usuario> userOpt = usuarioRepository.findByUsername(usuario.getUsername());

        if (userOpt.isPresent()) {
            Usuario user = userOpt.get();
            if (passwordEncoder.matches(usuario.getPassword(), user.getPassword())) {
                return jwtUtil.generateToken(usuario.getUsername());
            }
        }

        throw new RuntimeException("Usuário ou senha inválidos");
    }
}
