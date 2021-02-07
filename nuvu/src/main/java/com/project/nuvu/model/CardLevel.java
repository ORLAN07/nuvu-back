package com.project.nuvu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCardLevel;
    private Integer type;
    private String description;

}
