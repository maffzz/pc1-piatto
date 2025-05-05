package com.example.piatto_pc1.repository;

import com.example.piatto_pc1.domain.Pedido;
import com.example.piatto_pc1.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findPedidosByUsuario(Usuario usuario);}