package com.example.piatto_pc1.dto;

import com.example.piatto_pc1.domain.Role;
import com.example.piatto_pc1.domain.Usuario;
import lombok.Data;

@Data
public class MostrarUsuarioDTO {
    private Long id;
    private String nombreDeUsuario;
    private String nombreCompleto;
    private String correo;
    private Role role;

    public MostrarUsuarioDTO toDTO(Usuario usuario) {
        MostrarUsuarioDTO dto = new MostrarUsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombreDeUsuario(usuario.getNombreDeUsuario());
        dto.setNombreCompleto(usuario.getNombreCompleto());
        dto.setCorreo(usuario.getCorreo());
        dto.setRole(usuario.getRole());
        return dto;}}