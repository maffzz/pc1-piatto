package com.example.piatto_pc1.service;

import com.example.piatto_pc1.domain.Plato;
import com.example.piatto_pc1.exception.NotFound;
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
        if (platoRepository.findByNombre(nombre) == null) {
            throw new NotFound("plato no encontrado en el menú");}
        return platoRepository.findByNombre(nombre);}}