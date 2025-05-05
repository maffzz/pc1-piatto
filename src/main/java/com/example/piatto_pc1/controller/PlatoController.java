package com.example.piatto_pc1.controller;

import com.example.piatto_pc1.domain.Plato;
import com.example.piatto_pc1.domain.PlatoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plato")
@RequiredArgsConstructor
public class PlatoController {
    private final PlatoService platoService;

    @GetMapping("/menu_del_dia")
    ResponseEntity<List<Plato>> getPlatosEnMenuDelDia() {
        return ResponseEntity.ok(platoService.menuDelDia());}

    @GetMapping("/todos")
    ResponseEntity<List<Plato>> getPlatos() {
        return ResponseEntity.ok(platoService.getPlatos());}

    @GetMapping("/{nombre}")
    ResponseEntity<Plato> getPlatoByNombre(@Valid @PathVariable String nombre) {
        return ResponseEntity.ok(platoService.getPlatoByNombre(nombre));}}