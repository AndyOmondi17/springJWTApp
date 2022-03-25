//package io.getarrays.userservice.model;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.List;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "Staff")
//public class Staff1 implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "Id")
//    private int staffID;
//
//    @Column(name = "firstName")
//    private String firstName;
//
//    @Column(name = "lastName")
//    private String lastName;
//
//    @Column(name = "Email")
//    private String email;
//
//    @Column(name = "active")
//    private boolean active;
//
//    @Column(name = "paymentID")
//    private int paymentID;
//
//    @Column(name = "username")
//    private String username;
//
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @Column(name = "password")
//    private String password;
//
//    @Column(name = "pictreUrl")
//    private String pictureURL;
//
//    @OneToMany(mappedBy = "staff1" ,cascade = { CascadeType.REMOVE })
//    private List<Rental> rentals;
//
////    add this to users table
//    @ManyToOne
//    private Address address1;
//
////    add this to the User model
//    @ManyToOne
//    private Store store1;
//
//}
