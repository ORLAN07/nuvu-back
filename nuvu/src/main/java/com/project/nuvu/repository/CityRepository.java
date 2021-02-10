package com.project.nuvu.repository;

import com.project.nuvu.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    public List<City> findAll();

    @Query("select c from City c where c.country.code = ?1")
    public List<City> findCitiesByCountry(String codeCountry);

}
