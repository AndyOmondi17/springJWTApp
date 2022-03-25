package com.andy.springapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;
    private int paymentID;
    private String username;
    private String password;
    private String pictureURL;

    @OneToMany(mappedBy = "staff1" ,cascade = { CascadeType.REMOVE })
    private List<Rental> rentals;

    @ManyToOne
    private Address address1;
    @ManyToOne
    private Store store1;

    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public User(Long id, String firstName, String lastName, String email, boolean active, int paymentID, String username, String password, String pictureURL, Address address1, Store store1, Collection<Role> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.paymentID = paymentID;
        this.username = username;
        this.password = password;
        this.pictureURL = pictureURL;
        this.address1 = address1;
        this.store1 = store1;
        this.roles = roles;
    }
}
