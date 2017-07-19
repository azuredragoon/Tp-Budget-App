package com.example.terencepan.budgetapp.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Terence Pan on 6/28/2017.
 */
@Entity
@Table(name = "savedsearches")
public class SavedSearches {

    @Id
    @Column(name = "saved_search_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer savedSearchId;

    @Column(name = "stock_symbol")
    private String stockSymbol;

    @Column(name = "date_added")
    private Date dateAdded;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Override
    public String toString() {
        return "SavedSearches{" +
                "id=" + savedSearchId +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
