package com.example.terencepan.budgetapp.controllers;

import com.example.terencepan.budgetapp.view.Quote;
import com.example.terencepan.budgetapp.view.QuoteCall;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Terence Pan on 5/7/2017.
 */
@Controller
public class SearchController {

    public String apiCall = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=";
    public String symbol = "IBB";
    public String apiKey = "&apikey=F9PQ";
    public String currencySign = "$";

    @RequestMapping("/search")
    public String search(Model model){

        //temp
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject(apiCall + symbol + apiKey, Quote.class);

        QuoteCall stockCall = new QuoteCall();
        //stockCall.setSearchString("searchString");
        model.addAttribute("quoteSearch", stockCall);
        return "search";
    }

    @RequestMapping(value = "/processSearch1", method=RequestMethod.POST)
    public String processSearch(@ModelAttribute(value="quoteSearch") QuoteCall quoteCall, Model model) {

        //Store symbol search string
        String stockSymbol = quoteCall.getSearchString();

        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject(apiCall + stockSymbol + apiKey, Quote.class);

        //test print
        System.out.println(quote.toString());

        //Update attributes in model for display
        model.addAttribute("symbol", quote.getQuotedata().getSymbol());
        model.addAttribute("exchangeName", quote.getQuotedata().getExchangeName());
        model.addAttribute("latestPrice", quote.getQuotedata().getLatestPrice());
        model.addAttribute("amtChange", quote.getQuotedata().getPriceChange());
        model.addAttribute("perChange", quote.getQuotedata().getPriceChangePercentage());
        model.addAttribute("volume", quote.getQuotedata().getVolume());
        model.addAttribute("dailyLow", quote.getQuotedata().getDailyLow());
        model.addAttribute("dailyHigh", quote.getQuotedata().getDailyHigh());
        model.addAttribute("previousClose", quote.getQuotedata().getPreviousClose());

        return "user-action :: successful-search";
    }
}
