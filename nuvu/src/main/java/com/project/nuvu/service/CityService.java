package com.project.nuvu.service;

import com.project.nuvu.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    public List<City> findAll();
    public List<City> findByCountry(String codeCountry);

}
