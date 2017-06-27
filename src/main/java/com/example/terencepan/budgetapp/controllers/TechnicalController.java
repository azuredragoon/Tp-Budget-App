package com.example.terencepan.budgetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Terence Pan on 6/27/2017.
 */
@Controller
public class TechnicalController {

    private String currencySign = "$";

    @RequestMapping("/technical")
    public String index(Model model){
        return "technical";
    }

    @GetMapping(value = "/technical/s")
    public String getSearch(@RequestParam(value="searchString",required=false) String searchSymbol, Model model) {
        return "technical";
    }

    @RequestMapping("/technical/s")
    public String indexSearch(@RequestParam("searchSymbol") String searchSymbol, Model model){
        return "technical";
    }

}
