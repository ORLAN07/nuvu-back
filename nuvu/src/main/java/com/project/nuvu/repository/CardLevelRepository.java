package com.project.nuvu.repository;

import com.project.nuvu.model.CardLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardLevelRepository extends JpaRepository<CardLevel, Integer> {

    public List<CardLevel> findAll();

}
