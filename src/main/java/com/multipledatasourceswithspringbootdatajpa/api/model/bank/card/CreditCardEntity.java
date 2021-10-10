package com.multipledatasourceswithspringbootdatajpa.api.model.bank.card;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "card_tb")
public class CreditCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "number")
    private String number;
}
