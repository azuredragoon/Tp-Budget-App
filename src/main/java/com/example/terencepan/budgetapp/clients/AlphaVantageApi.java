package com.example.terencepan.budgetapp.clients;

import com.example.terencepan.budgetapp.view.Quote;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Terence Pan on 6/20/2017.
 */
public class AlphaVantageApi {

    private String apiCall = "https://www.alphavantage.co/query?function=";
    private String symbolString = "&symbol=";
    private String apiKey = "&apikey=F9PQ";

    private enum stockApiFunctions{
        GLOBAL_QUOTE, SMA, EMA, MACD
    }

    private Quote quoteData;

    public Quote getQuoteData() {
        return quoteData;
    }

    public void setQuoteData(Quote quoteData) {
        this.quoteData = quoteData;
    }

    public AlphaVantageApi(String stockSymbol){

        RestTemplate restTemplate = new RestTemplate();
        String uri = apiCall + stockApiFunctions.GLOBAL_QUOTE + symbolString + stockSymbol + apiKey;
        System.out.println(uri);
        quoteData = restTemplate.getForObject(uri, Quote.class);

    }



}
