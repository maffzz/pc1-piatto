package com.example.piatto_pc1.dto;

import java.util.Map;

public class CrearPedidoDTO {
    private Map<String, Integer> cantidadPorPlato;

    public Map<String, Integer> getCantidadPorPlato() {
        return cantidadPorPlato;}

    public void setCantidadPorPlato(Map<String, Integer> cantidadPorPlato) {
        this.cantidadPorPlato = cantidadPorPlato;}}