package com.example.terencepan.budgetapp.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Created by Terence Pan on 6/23/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    @JsonProperty("Realtime Global Securities Quote")
    private QuoteData quotedata;

    public QuoteData getQuotedata() {
        return quotedata;
    }

    public void setQuotedata(QuoteData quotedata) {
        this.quotedata = quotedata;
    }

}
