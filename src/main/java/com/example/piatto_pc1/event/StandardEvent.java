package com.example.piatto_pc1.event;

import org.springframework.context.ApplicationEvent;

public class StandardEvent extends ApplicationEvent {
    private final String message;

    public StandardEvent(Object source, String message) {
        super(source);
        this.message = message;}

    public String getMessage() {
        return message;}}