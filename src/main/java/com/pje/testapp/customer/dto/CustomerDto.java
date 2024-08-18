package com.pje.testapp.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class CustomerDto {

    private String customerReference;

    private String customerName;

    private String addressLine1;

    private String addressLine2;

    private String town;

    private String county;

    private String country;

    private String postcode;
}
