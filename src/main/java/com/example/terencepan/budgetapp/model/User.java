package com.example.terencepan.budgetapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Terence Pan on 6/28/2017.
 */
@Entity
@Table(name = "user")
public class User implements Serializable{

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username", nullable = false)
    private String userName;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<SavedSearches> savedSearches = new ArrayList<SavedSearches>();

    public User(String firstName, String lastName, String userName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

}
