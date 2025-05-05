package com.example.piatto_pc1.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    private String descripcion;

    private Integer precio;

    private Boolean isInMenu;

    @ManyToMany(mappedBy = "platos")
    @JsonBackReference
    private List<Pedido> pedidos;}