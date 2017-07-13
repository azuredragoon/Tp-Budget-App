package com.example.terencepan.budgetapp.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Terence Pan on 7/13/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Technical {

    @JsonProperty("Meta Data")
    private MetaData metaData;


    @JsonProperty("Technical Analysis: EMA")
    private TechnicalData technicalData;

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public TechnicalData getTechnicalAnalysis() {
        return technicalData;
    }

    public void setTechnicalAnalysis(TechnicalData technicalAnalysis) {
        this.technicalData = technicalAnalysis;
    }


}
