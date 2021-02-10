package com.project.nuvu.repository;

import com.project.nuvu.model.CardBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardBrandRepository extends JpaRepository<CardBrand, Integer> {
}
