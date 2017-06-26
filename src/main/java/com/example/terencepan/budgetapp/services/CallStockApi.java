package com.example.terencepan.budgetapp.services;

import com.example.terencepan.budgetapp.clients.AlphaVantageApi;
import com.example.terencepan.budgetapp.view.Quote;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Terence Pan on 6/23/2017.
 */
public class CallStockApi {

    Quote quoteData;

    public Quote getQuoteData() {
        return quoteData;
    }

    public void setQuoteData(Quote quoteData) {
        this.quoteData = quoteData;
    }


    public CallStockApi(String stockSymbol){

        AlphaVantageApi stockApi = new AlphaVantageApi(stockSymbol);

        quoteData = stockApi.getQuoteData();
    }

}
