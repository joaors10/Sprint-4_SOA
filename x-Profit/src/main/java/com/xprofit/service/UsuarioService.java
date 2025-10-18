package com.xprofit.service;

import com.xprofit.model.entity.Usuario;
import com.xprofit.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Usuario registrarUsuario(String username, String password) {
        String senhaCriptografada = passwordEncoder.encode(password);
        Usuario usuario = new Usuario(username, senhaCriptografada);
        return usuarioRepository.save(usuario);
    }

    public boolean autenticarUsuario(String username, String password) {
        return usuarioRepository.findByUsername(username)
                .map(usuario -> passwordEncoder.matches(password, usuario.getPassword()))
                .orElse(false);
    }
}
