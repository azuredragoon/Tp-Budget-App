package com.example.terencepan.budgetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Terence Pan on 5/9/2017.
 */
@Controller
public class RegisterController {
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    String register(){
        return "register";
    }
}

