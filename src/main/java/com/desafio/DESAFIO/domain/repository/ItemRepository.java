package com.desafio.DESAFIO.domain.repository;

import com.desafio.DESAFIO.domain.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
