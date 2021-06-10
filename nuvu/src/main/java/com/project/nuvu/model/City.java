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
public class City implements Serializable {

    @Id
    @Column(name = "id_city")
    private Integer idCity;

    @ManyToOne
    @JoinColumn(name = "country_code")
    private Country country;
    private String name;

}
