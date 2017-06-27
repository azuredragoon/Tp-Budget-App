package com.example.terencepan.budgetapp.controllers;

import com.example.terencepan.budgetapp.services.CallStockApi;
import com.example.terencepan.budgetapp.view.Quote;
import com.example.terencepan.budgetapp.view.QuoteCall;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Terence Pan on 5/7/2017.
 */
@Controller
public class SavedSearchesController {

    private String currencySign = "$";

    @RequestMapping("/saved-searches")
    public String index(Model model){

        QuoteCall stockCall = new QuoteCall();
        model.addAttribute("quoteSearch", stockCall);
        model.addAttribute("quoteCall", stockCall);
        model.addAttribute("searchString", "");

        model.addAttribute("message", "Run a search for info to show up here!");
        return "savedsearches";
    }

    @GetMapping(value = "/saved-searches/s")
    public String getSearch(@RequestParam(value="searchString",required=false) String searchSymbol, Model model) {
        if(searchSymbol==null)
            return "index";

        CallStockApi callStockApi = new CallStockApi(searchSymbol);
        Quote quote = callStockApi.getQuoteData();

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
        model.addAttribute("lastUpdated", quote.getQuotedata().getLastUpdated());
        model.addAttribute("amtChange", currencySign + quote.getQuotedata().getPriceChange());
        model.addAttribute("perChange", quote.getQuotedata().getPriceChangePercentage());
        model.addAttribute("volume", quote.getQuotedata().getVolume());
        model.addAttribute("dailyLow", currencySign + quote.getQuotedata().getDailyLow());
        model.addAttribute("dailyHigh", currencySign + quote.getQuotedata().getDailyHigh());
        model.addAttribute("previousClose", currencySign + quote.getQuotedata().getPreviousClose());
        return "savedsearches";
    }

    @RequestMapping("/saved-searches/s")
    public String indexSearch(@RequestParam("searchSymbol") String searchSymbol, Model model){

        CallStockApi callStockApi = new CallStockApi(searchSymbol);
        Quote quote = callStockApi.getQuoteData();
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
        model.addAttribute("lastUpdated", quote.getQuotedata().getLastUpdated());
        model.addAttribute("amtChange", currencySign + quote.getQuotedata().getPriceChange());
        model.addAttribute("perChange", quote.getQuotedata().getPriceChangePercentage());
        model.addAttribute("volume", quote.getQuotedata().getVolume());
        model.addAttribute("dailyLow", currencySign + quote.getQuotedata().getDailyLow());
        model.addAttribute("dailyHigh", currencySign + quote.getQuotedata().getDailyHigh());
        model.addAttribute("previousClose", currencySign + quote.getQuotedata().getPreviousClose());
        return "savedsearches";
    }

}
