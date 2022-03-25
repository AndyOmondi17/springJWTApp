package com.andy.springapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Film")

public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int filmID;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "releaseYear")
    private Date releaseYear;

    @Column(name = "rentalDuration")
    private byte rentalDuration;

    @Column(name = "rentalRate")
    private BigDecimal rentalRate;

    @Column(name = "length")
    private int length;

    @Column(name = "replacementCost")
    private BigDecimal replacementCost;

    @Column(name = "rating")
    private String rating;

    @Column(name = "specialFeatures")
    private String specialFeatures;

    @Column(name = "fullText")
    private String fulltext;

    @OneToMany(mappedBy = "filmInventory")
    private List<Inventory> inventories;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_actor",joinColumns = {@JoinColumn(referencedColumnName = "Id")},inverseJoinColumns = {@JoinColumn(referencedColumnName = "Id")})
    private List<Actor> actors;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_category",joinColumns = {@JoinColumn(referencedColumnName = "Id")},inverseJoinColumns = {@JoinColumn(referencedColumnName = "Id1", insertable = false, updatable = false)})
    private List<Category> categories;

    @ManyToOne
    private  Language language1;


}
