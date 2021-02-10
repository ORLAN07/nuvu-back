package com.project.nuvu.service;

import com.project.nuvu.model.CardBrand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardBrandService {

    public List<CardBrand> findAll();
}
