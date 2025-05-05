package com.example.piatto_pc1.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "pedido_cantidad_por plato",
            joinColumns = @JoinColumn(name = "pedido_id"))
    @MapKeyColumn(name = "plato")
    @Column(name = "cantidad")
    private Map<String, Integer> cantidadPorPlato = new HashMap<>();

    private Boolean isPrepared = false;

    @ManyToOne
    private Usuario usuario;

    @ManyToMany
    @JsonBackReference
    private List<Plato> platos;}