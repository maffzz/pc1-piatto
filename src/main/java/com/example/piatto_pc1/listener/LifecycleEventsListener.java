package com.example.piatto_pc1.listener;

import org.springframework.context.event.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

@Component
public class LifecycleEventsListener {

    @EventListener
    public void handleContextRefreshed(ContextRefreshedEvent event) {
        System.out.println("📦 ContextRefreshedEvent: El contexto fue inicializado o actualizado.");}

    @EventListener
    public void handleContextStarted(ContextStartedEvent event) {
        System.out.println("📦 ContextStartedEvent: El contexto fue iniciado.");}

    @EventListener
    public void handleContextStopped(ContextStoppedEvent event) {
        System.out.println("📦 ContextStoppedEvent: El contexto fue detenido.");}

    @EventListener
    public void handleContextClosed(ContextClosedEvent event) {
        System.out.println("📦 ContextClosedEvent: El contexto fue cerrado.");}

    @EventListener
    public void handleRequestHandled(RequestHandledEvent event) {
        System.out.println("📦 RequestHandledEvent: Se procesó un request HTTP.");}}