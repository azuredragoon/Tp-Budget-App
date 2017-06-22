package com.example.terencepan.budgetapp.view;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * Created by Terence Pan on 6/22/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteData {

    @JsonProperty("01. Symbol")
    private String symbol;

    @JsonProperty("02. Exchange Name")
    private String exchangeName;

    @JsonProperty("03. Latest Price")
    private double latestPrice;

    @JsonProperty("04. Open (Current Trading Day)")
    private double dailyOpen;

    @JsonProperty("05. High (Current Trading Day)")
    private double dailyHigh;

    @JsonProperty("06. Low (Current Trading Day)")
    private double dailyLow;

    @JsonProperty("07. Close (Previous Trading Day)")
    private double previousClose;

    @JsonProperty("08. Price Change")
    private double priceChange;

    @JsonProperty("09. Price Change Percentage")
    private String priceChangePercentage;

    @JsonProperty("10. Volume (Current Trading Day)")
    private String volume;

    @JsonProperty("11. Last Updated")
    private String lastUpdated;


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public double getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(double latestPrice) {
        this.latestPrice = latestPrice;
    }

    public double getDailyOpen() {
        return dailyOpen;
    }

    public void setDailyOpen(double dailyOpen) {
        this.dailyOpen = dailyOpen;
    }

    public double getDailyHigh() {
        return dailyHigh;
    }

    public void setDailyHigh(double dailyHigh) {
        this.dailyHigh = dailyHigh;
    }

    public double getDailyLow() {
        return dailyLow;
    }

    public void setDailyLow(double dailyLow) {
        this.dailyLow = dailyLow;
    }

    public double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(double previousClose) {
        this.previousClose = previousClose;
    }

    public double getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(double priceChange) {
        this.priceChange = priceChange;
    }

    public String getPriceChangePercentage() {
        return priceChangePercentage;
    }

    public void setPriceChangePercentage(String priceChangePercentage) {
        this.priceChangePercentage = priceChangePercentage;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
