package com.project.nuvu.service;

import com.project.nuvu.model.CardLevel;
import com.project.nuvu.repository.CardLevelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CardLevelServiceImpl implements CardLevelService{

    private final CardLevelRepository cardLevelRepository;

    @Override
    public List<CardLevel> findAll() {
        return cardLevelRepository.findAll();
    }
}
