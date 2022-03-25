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
@Table(name = "Country")
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int countryID;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "country1")
    private List<City> cities;

    public Country(int countryID, String country) {
        this.countryID = countryID;
        this.country = country;
    }
}
