package com.example.piatto_pc1.listener;

import com.example.piatto_pc1.event.CustomEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener {
    @Async
    @EventListener
    public void handleCustomEvent(CustomEvent event) {
        System.out.println("[ASYNC] Handling CustomEvent: " + event.getMessage());}}