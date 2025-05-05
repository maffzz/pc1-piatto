package com.example.piatto_pc1.repository;

import com.example.piatto_pc1.domain.Plato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatoRepository extends JpaRepository<Plato, Long> {
    List<Plato> findAllByNombreIn(List<String> nombres);
    List<Plato> findAllByIsInMenu(Boolean isInMenu);
    Plato findByNombre(String nombre);}