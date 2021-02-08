package com.project.nuvu.service;

import com.project.nuvu.model.CardLevel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardLevelService {

    public List<CardLevel> findAll();

}
