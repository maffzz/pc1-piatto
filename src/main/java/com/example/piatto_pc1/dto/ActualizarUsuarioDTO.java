package com.example.piatto_pc1.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarUsuarioDTO {
    @NotNull(message = "correo obligatorio")
    private String correo;
    @NotNull(message = "contraseña obligatoria")
    private String password;}