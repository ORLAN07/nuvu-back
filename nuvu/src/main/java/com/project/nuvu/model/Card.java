package com.project.nuvu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_card")
    private Integer idCard;
    private String brand;
    @Column(name = "is_credit")
    private boolean isCredit;
    @Column(name = "date_due")
    private Date dateDue;
    @ManyToOne
    @JoinColumn(name = "card_level")
    private CardLevel cardLevel;
    @Column(name = "security_code")
    private String securityCode;
    @ManyToOne
    private City city;
    private Double price;

}
