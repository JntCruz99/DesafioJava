package com.desafio.DESAFIO.domain.repository;

import com.desafio.DESAFIO.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
