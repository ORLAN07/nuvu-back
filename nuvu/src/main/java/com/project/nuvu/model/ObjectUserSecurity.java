package com.project.nuvu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ObjectUserSecurity implements Serializable {

    private Integer idUser;
    private String username;
    private String token;

}
