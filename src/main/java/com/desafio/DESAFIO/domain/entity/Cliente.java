package com.desafio.DESAFIO.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private int idade;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Pedido> pedidoList;
}
