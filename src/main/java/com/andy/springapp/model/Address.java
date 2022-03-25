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
@Table(name = "Address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int addressID;

    @Column(name = "address")
    private String address;

    @Column(name = "address2")
    private String address2;

    @Column(name = "district")
    private String district;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "phone")
    private int phone;

    @ManyToOne
    private City city1;

    @OneToMany(mappedBy = "address")
    private List<Customer> customers;

//    change Staff1 to User
    @OneToMany(mappedBy = "address1")
    private List<User> users;

    @OneToMany(mappedBy = "address1")
    private List<Store> stores;

    public Address(int addressID, String address, String address2, String district, String postal_code, int phone, City city1) {
        this.addressID = addressID;
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.postal_code = postal_code;
        this.phone = phone;
        this.city1 = city1;
    }
}
