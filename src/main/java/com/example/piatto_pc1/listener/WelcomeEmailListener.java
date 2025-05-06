package com.example.piatto_pc1.listener;

import com.example.piatto_pc1.event.WelcomeEmailEvent;
import com.example.piatto_pc1.service.EmailService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class WelcomeEmailListener {
    final private EmailService emailService;

    public WelcomeEmailListener(EmailService emailService) {
        this.emailService = emailService;}

    @Async
    @EventListener
    public void sendWelcomeEmail(WelcomeEmailEvent welcomeEmailEvent) {
        emailService.sendEmail(welcomeEmailEvent.getCorreo(), "bienvenido",
                "hola " + welcomeEmailEvent.getNombreDeUsuario() + ", bienvenido a piatto");}}