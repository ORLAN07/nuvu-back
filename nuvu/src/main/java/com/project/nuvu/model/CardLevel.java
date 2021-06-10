package com.project.nuvu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "card_level")
public class CardLevel implements Serializable {

    @Id
    @Column(name = "id_card_level")
    private Integer idCardLevel;
    private Integer type;
    private String description;

}
