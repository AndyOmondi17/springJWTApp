package com.andy.springapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Rental")
public class Rental implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int rentalID;

    @Column(name = "rentalDate")
    private Date rentalDate;

    @Column(name = "returnDate")
    private Date returnDate;

    @Column(name = "lastUpdate")
    private Timestamp lastUpdate;

//    change this to User user1
    @ManyToOne
    private User staff1;

    @ManyToOne
    private Customer customer1;

}
