package com.example.piatto_pc1.domain;

import com.example.piatto_pc1.repository.PlatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlatoService {
    private final PlatoRepository platoRepository;

    public List<Plato> menuDelDia() {
        return platoRepository.findAllByIsInMenu(true);}

    public List<Plato> getPlatos() {
        return platoRepository.findAll();}

    public Plato getPlatoByNombre(String nombre) {
        return platoRepository.findByNombre(nombre);}}