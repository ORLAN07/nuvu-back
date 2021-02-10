package com.project.nuvu.service;

import com.project.nuvu.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {

    public List<Country> findAll();
}
