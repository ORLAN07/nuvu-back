package com.project.nuvu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCard;
    private String brand;
    private boolean isCredit;
    @ManyToOne
    private CardLevel cardLevel;
    private String securityCode;
    @ManyToOne
    private City city;
    private Double price;

}
