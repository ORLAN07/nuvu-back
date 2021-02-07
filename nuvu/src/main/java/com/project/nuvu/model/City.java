package com.project.nuvu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class City {

    @Id
    @Column(name = "id_city")
    private Integer idCity;

    @ManyToOne
    @JoinColumn(name = "country_code")
    private Country country;
    private String name;

}
