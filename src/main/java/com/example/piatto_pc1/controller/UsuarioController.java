package com.example.piatto_pc1.controller;

import com.example.piatto_pc1.domain.Usuario;
import com.example.piatto_pc1.domain.UsuarioService;
import com.example.piatto_pc1.dto.ActualizarUsuarioDTO;
import com.example.piatto_pc1.dto.MostrarUsuarioDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PatchMapping("/{nombreDeUsuario}/actualizar")
    public ResponseEntity<MostrarUsuarioDTO> actualizarCorreoContrasenia(@Valid @PathVariable String nombreDeUsuario, @Valid @RequestBody ActualizarUsuarioDTO dto) {
        Usuario user = usuarioService.actualizarCorreoContrasenia(nombreDeUsuario, dto);
        return ResponseEntity.ok(new MostrarUsuarioDTO().toDTO(user));}}