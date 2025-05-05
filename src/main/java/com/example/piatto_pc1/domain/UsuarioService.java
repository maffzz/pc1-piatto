package com.example.piatto_pc1.domain;

import com.example.piatto_pc1.dto.ActualizarUsuarioDTO;
import com.example.piatto_pc1.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario actualizarCorreoContrasenia(String nombreDeUsuario, ActualizarUsuarioDTO dto) {
        Usuario user = userRepository.findByNombreDeUsuario(nombreDeUsuario);
        user.setCorreo(dto.getCorreo());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        return user;}}