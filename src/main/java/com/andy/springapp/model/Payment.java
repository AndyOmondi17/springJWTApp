package com.andy.springapp.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Payment")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int paymentID;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "paymentDate")
    private Date paymentDate;

    @ManyToOne
    private Rental rental1;

    @ManyToOne
    private Customer customer1;

//    change this to User user
    @ManyToOne
    private User staff1;


}
