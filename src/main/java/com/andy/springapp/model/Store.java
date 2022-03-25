package com.andy.springapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Store")
public class Store  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private  int storeID;

//    change Staff1 to Users
    @OneToMany(mappedBy = "store1")
    private List<User> users;

    @ManyToOne
    Address address1;

    public Store(int storeID, Address address1) {
        this.storeID = storeID;
        this.address1 = address1;
    }
}
