package com.example.terencepan.budgetapp.controllers;

import com.example.terencepan.budgetapp.view.Quote;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Terence Pan on 5/7/2017.
 */
@Controller
public class IndexController {

    public String apiCall = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=IBB&apikey=F9PQ";

    @RequestMapping("/")
    public String index(Model model){

        //temp
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject(apiCall, Quote.class);
        System.out.println(quote.toString());
        model.addAttribute("symbol", quote.getQuotedata().getSymbol());
        model.addAttribute("latestPrice", quote.getQuotedata().getLatestPrice());
        model.addAttribute("amtChange", quote.getQuotedata().getPriceChange());
        model.addAttribute("perChange", quote.getQuotedata().getPriceChangePercentage());
        return "index";
    }


}
