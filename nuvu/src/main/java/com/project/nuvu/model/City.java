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
    @Column(name = "idCity")
    private Integer idCity;

    //@Column(name = "country_code")

    @ManyToOne
    @JoinColumn(name = "country_code")
    private Country country;
    private String name;

}
