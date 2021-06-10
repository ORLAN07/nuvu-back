package com.project.nuvu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_card")
    private Integer idCard;

    @OneToOne
    @JoinColumn(name = "card_brand")
    private CardBrand brand;

    @Column(name = "is_credit")
    private boolean isCredit;

    @Column(name = "date_due")
    private Date dateDue;

    @ManyToOne
    @JoinColumn(name = "id_card_level")
    private CardLevel cardLevel;

    @Column(name = "security_code")
    private String securityCode;

    @OneToOne
    @JoinColumn(name = "id_city")
    private City city;

    private Double price;

}
