package com.xprofit.controller;

import com.xprofit.config.JwtUtil;
import com.xprofit.model.entity.Usuario;
import com.xprofit.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @Operation(summary = "Registrar novo usuário", description = "Cria um novo usuário no sistema com nome de usuário e senha.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos enviados"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.registrarUsuario(usuario.getUsername(), usuario.getPassword());
        return ResponseEntity.ok(novoUsuario);
    }

    @Operation(summary = "Login do usuário", description = "Autentica um usuário com base em nome de usuário e senha, retornando um token JWT em caso de sucesso.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso, token JWT retornado"),
            @ApiResponse(responseCode = "401", description = "Usuário ou senha incorretos"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        boolean autenticado = usuarioService.autenticarUsuario(usuario.getUsername(), usuario.getPassword());

        if (autenticado) {
            String token = jwtUtil.generateToken(usuario.getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        } else {
            return ResponseEntity.status(401).body(Map.of("erro", "Usuário ou senha incorretos!"));
        }
    }
}
