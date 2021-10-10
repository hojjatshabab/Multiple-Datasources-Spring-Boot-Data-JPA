package com.multipledatasourceswithspringbootdatajpa.api.model.order;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_tb")
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "number")
    private Integer number;
    @Column(name = "cost")
    private Double cost;


}
