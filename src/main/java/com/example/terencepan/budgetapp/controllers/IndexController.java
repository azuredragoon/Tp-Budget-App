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
public class IndexController {

    private String apiCall = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=";
    private String symbol = "IBB";
    private String apiKey = "&apikey=F9PQ";
    private String currencySign = "$";
    private String symbolparam;

    @RequestMapping("/")
    public String index(Model model){

        QuoteCall stockCall = new QuoteCall();
        model.addAttribute("quoteSearch", stockCall);
        model.addAttribute("quoteCall", stockCall);
        model.addAttribute("searchString", "");

        model.addAttribute("message", "Run a search for info to show up here!");
        return "index";
    }

    @GetMapping(value = "/s")
    public String getSearch(@RequestParam(value="searchString",required=false) String searchSymbol, Model model) {
        if(searchSymbol==null)
            return "index";
        RestTemplate restTemplate = new RestTemplate();

        Quote quote = restTemplate.getForObject(apiCall + searchSymbol + apiKey, Quote.class);

        //

        QuoteCall stockCall = new QuoteCall();
        stockCall.setSearchString(searchSymbol);
        model.addAttribute("quoteSearch", stockCall);
        model.addAttribute("quoteCall", stockCall);


        //
        model.addAttribute("searchString", "");

        model.addAttribute("symbol", quote.getQuotedata().getSymbol());
        model.addAttribute("exchangeName", quote.getQuotedata().getExchangeName());
        model.addAttribute("latestPrice", currencySign + quote.getQuotedata().getLatestPrice());
        model.addAttribute("amtChange", currencySign + quote.getQuotedata().getPriceChange());
        model.addAttribute("perChange", quote.getQuotedata().getPriceChangePercentage());
        model.addAttribute("volume", quote.getQuotedata().getVolume());
        model.addAttribute("dailyLow", currencySign + quote.getQuotedata().getDailyLow());
        model.addAttribute("dailyHigh", currencySign + quote.getQuotedata().getDailyHigh());
        model.addAttribute("previousClose", currencySign + quote.getQuotedata().getPreviousClose());
        return "index";
    }

    @RequestMapping("/s")
    public String indexSearch(@RequestParam("searchSymbol") String searchSymbol, Model model){

        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject(apiCall + searchSymbol + apiKey, Quote.class);

        //

        QuoteCall stockCall = new QuoteCall();
        stockCall.setSearchString(searchSymbol);
        model.addAttribute("quoteSearch", stockCall);
        model.addAttribute("quoteCall", stockCall);


        //
        model.addAttribute("searchString", "");

        model.addAttribute("symbol", quote.getQuotedata().getSymbol());
        model.addAttribute("exchangeName", quote.getQuotedata().getExchangeName());
        model.addAttribute("latestPrice", currencySign + quote.getQuotedata().getLatestPrice());
        model.addAttribute("amtChange", currencySign + quote.getQuotedata().getPriceChange());
        model.addAttribute("perChange", quote.getQuotedata().getPriceChangePercentage());
        model.addAttribute("volume", quote.getQuotedata().getVolume());
        model.addAttribute("dailyLow", currencySign + quote.getQuotedata().getDailyLow());
        model.addAttribute("dailyHigh", currencySign + quote.getQuotedata().getDailyHigh());
        model.addAttribute("previousClose", currencySign + quote.getQuotedata().getPreviousClose());
        return "index";
    }

}
