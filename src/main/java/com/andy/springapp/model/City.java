package com.andy.springapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "City")
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int cityID;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "city1")
    private List<Address> addresses;

    @ManyToOne
    private Country country1;

    public City(int cityID, String city, Country country1) {
        this.cityID = cityID;
        this.city = city;
        this.country1 = country1;
    }
}
