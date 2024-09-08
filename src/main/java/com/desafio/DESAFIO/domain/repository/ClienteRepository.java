package com.desafio.DESAFIO.domain.repository;

import com.desafio.DESAFIO.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
