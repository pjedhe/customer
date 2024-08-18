package com.pje.testapp.customer.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Customer extends  BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Long customerId;

    private String customerReference;

    private String customerName;

    private String addressLine1;

    private String addressLine2;

    private String town;

    private String county;

    private String country;

    private String postcode;


}
