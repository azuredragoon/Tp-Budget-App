package com.example.terencepan.budgetapp.view;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Terence Pan on 7/13/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TechnicalData {

    // and then "other" stuff:
    protected Map<String,Object> other = new HashMap<String,Object>();

    public Object get(String name) {
        return other.get(name);
    }

    // "any getter" needed for serialization    
    @JsonAnyGetter
    public Map<String,Object> any() {
        return other;
    }

    @JsonAnySetter
    public void set(String name, Object value) {
        other.put(name, value);
    }


}
