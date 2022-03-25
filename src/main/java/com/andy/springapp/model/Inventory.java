package com.andy.springapp.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Inventory")
public class Inventory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int inventoryID;

    @ManyToOne
    private Film filmInventory;

}
