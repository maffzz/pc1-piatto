package com.example.piatto_pc1.controller;

import com.example.piatto_pc1.domain.Pedido;
import com.example.piatto_pc1.domain.PedidoService;
import com.example.piatto_pc1.dto.CrearPedidoDTO;
import com.example.piatto_pc1.dto.PedidoResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;

    @PostMapping
    ResponseEntity<PedidoResponseDTO> crearPedido(@Valid @RequestBody CrearPedidoDTO dto, Principal principal) {
        System.out.println("usuario autenticado: " + principal.getName());
        Pedido pedido = pedidoService.crearPedido(dto, principal.getName());
        return ResponseEntity.ok(new PedidoResponseDTO().toResponseDTO(pedido));}
    
    @GetMapping("/{nombreDeUsuario}")
    ResponseEntity<List<PedidoResponseDTO>> getPedidosByUsuario(@Valid @PathVariable String nombreDeUsuario, Principal principal) {
        System.out.println("usuario autenticado: " + principal.getName());
        List<Pedido> pedidos = pedidoService.getPedidosByUsuario(nombreDeUsuario);
        List<PedidoResponseDTO> pedidosDTO = pedidos.stream()
        .map(pedido -> new PedidoResponseDTO().toResponseDTO(pedido))
        .collect(Collectors.toList());
    return ResponseEntity.ok(pedidosDTO);}

    @DeleteMapping("/{id}")
    void eliminarPedido(@Valid @PathVariable Long id, Principal principal) {
        System.out.println("usuario autenticado: " + principal.getName());
        pedidoService.eliminarPedido(id);}}