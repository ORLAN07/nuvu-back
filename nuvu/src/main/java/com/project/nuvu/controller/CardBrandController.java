package com.project.nuvu.controller;

import com.project.nuvu.model.CardBrand;
import com.project.nuvu.service.CardBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/card-brands")
public class CardBrandController {

    @Autowired
    private CardBrandService cardBrandService;

    @RequestMapping(method = RequestMethod.GET)
    public List<CardBrand> get() {
        return cardBrandService.findAll();
    }
}
