package com.project.nuvu.service;

import com.project.nuvu.model.CardBrand;
import com.project.nuvu.repository.CardBrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CardBrandServiceImpl implements CardBrandService{

    private final CardBrandRepository cardBrandRepository;

    @Override
    public List<CardBrand> findAll() {
        return cardBrandRepository.findAll();
    }
}
