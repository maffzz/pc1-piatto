package com.example.piatto_pc1.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class WelcomeEmailEvent extends ApplicationEvent {
    private final String correo;
    private final String nombreDeUsuario;

    public WelcomeEmailEvent(Object source, String correo, String nombreDeUsuario) {
        super(source);
        this.correo = correo;
        this.nombreDeUsuario = nombreDeUsuario;}}