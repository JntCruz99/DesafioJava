package com.desafio.DESAFIO.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private LocalDate date;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Item> itensList;

    private double valorTotal;
}
