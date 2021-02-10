package com.project.nuvu.controller;

import com.project.nuvu.model.City;
import com.project.nuvu.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(method = RequestMethod.GET)
    public List<City> get() {
        return cityService.findAll();
    }

    @RequestMapping(value = "/country/{code-country}", method = RequestMethod.GET)
    public List<City> getByCountry(@PathVariable("code-country") String codeCountry) {
        return cityService.findByCountry(codeCountry);
    }


}
