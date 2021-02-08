package com.project.nuvu.controller;

import com.project.nuvu.model.CardLevel;
import com.project.nuvu.service.CardLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/card-levels")
public class CardLevelController {

    @Autowired
    private CardLevelService cardLevelService;

    @RequestMapping(method = RequestMethod.GET)
    public List<CardLevel> get() {
        return cardLevelService.findAll();
    }

}
