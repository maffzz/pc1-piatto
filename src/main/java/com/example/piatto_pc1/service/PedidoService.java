package com.example.piatto_pc1.service;

import com.example.piatto_pc1.domain.Pedido;
import com.example.piatto_pc1.domain.Plato;
import com.example.piatto_pc1.domain.Usuario;
import com.example.piatto_pc1.dto.CrearPedidoDTO;
import com.example.piatto_pc1.exception.Conflict;
import com.example.piatto_pc1.exception.NotFound;
import com.example.piatto_pc1.repository.PedidoRepository;
import com.example.piatto_pc1.repository.PlatoRepository;
import com.example.piatto_pc1.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;
    private final PlatoRepository platoRepository;

    public Pedido crearPedido(CrearPedidoDTO dto, String username) {
        Usuario usuario = usuarioRepository.findByNombreDeUsuario(username);
        Map<String, Integer> cantidadPorPlato = dto.getCantidadPorPlato();
        List<Plato> platos = platoRepository.findAllByNombreIn(new ArrayList<>(cantidadPorPlato.keySet()));
        if (platos.size() != cantidadPorPlato.size()) {
            throw new NotFound("uno o más platos no existen en el sistema");}
        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setCantidadPorPlato(cantidadPorPlato);
        pedido.setPlatos(platos);
        return pedidoRepository.save(pedido);}

    public List<Pedido> getPedidosByUsuario(String nombreDeUsuario) {
        Usuario usuario = usuarioRepository.findByNombreDeUsuario(nombreDeUsuario);
        if (usuario == null) {
            throw new NotFound("usuario no encontrado");}
        return pedidoRepository.findPedidosByUsuario(usuario);}

    public void eliminarPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("pedido no encontrado"));
        if (pedido.getIsPrepared() == true) {
            throw new Conflict("no se puede eliminar un pedido preparado");}
        pedidoRepository.deleteById(id);}}