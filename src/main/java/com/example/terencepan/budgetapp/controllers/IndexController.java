package com.example.terencepan.budgetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Terence Pan on 5/7/2017.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    String index(){
        return "index";
    }
}
