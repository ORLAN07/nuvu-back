package com.project.nuvu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Integer idClient;
    private String name1;
    private String name2;
    private String surname1;
    private String surname2;
    private Integer year;
    private String phone;
    private String email;

    @OneToOne
    @JoinColumn(name = "id_city")
    private City city;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Card> cards = new HashSet<>();

}
