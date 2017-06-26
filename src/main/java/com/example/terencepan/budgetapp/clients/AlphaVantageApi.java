package com.example.terencepan.budgetapp.clients;

import com.example.terencepan.budgetapp.view.Quote;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Terence Pan on 6/20/2017.
 */
public class AlphaVantageApi {

    private String apiCall = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=";
    private String apiKey = "&apikey=F9PQ";

    private Quote quoteData;

    public Quote getQuoteData() {
        return quoteData;
    }

    public void setQuoteData(Quote quoteData) {
        this.quoteData = quoteData;
    }

    public AlphaVantageApi(String stockSymbol){

        RestTemplate restTemplate = new RestTemplate();

        quoteData = restTemplate.getForObject(apiCall + stockSymbol + apiKey, Quote.class);

    }



}
