package com.example.piatto_pc1.dto;

import com.example.piatto_pc1.domain.Pedido;
import lombok.Data;
import java.util.Map;

@Data
public class PedidoResponseDTO {
    private Long id;
    private Map<String, Integer> cantidadPorPlato;
    private Long usuarioId;

    public PedidoResponseDTO toResponseDTO(Pedido pedido) {
        PedidoResponseDTO responseDTO = new PedidoResponseDTO();
        responseDTO.setId(pedido.getId());
        responseDTO.setCantidadPorPlato(pedido.getCantidadPorPlato());
        responseDTO.setUsuarioId(pedido.getUsuario().getId());
        return responseDTO;}}