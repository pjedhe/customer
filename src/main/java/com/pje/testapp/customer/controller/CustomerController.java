package com.pje.testapp.customer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pje.testapp.customer.constants.CustomerConstants;
import com.pje.testapp.customer.dto.CustomerDto;
import com.pje.testapp.customer.dto.ErrorResponseDto;
import com.pje.testapp.customer.dto.ResponseDto;
import com.pje.testapp.customer.service.ICustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class CustomerController {

    private ICustomerService iCustomerService;

    @Operation(
            summary = "Create Account REST API",
            description = "REST API to create new Customer"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        iCustomerService.storeCustomer(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CustomerConstants.STATUS_201, CustomerConstants.MESSAGE_201));
    } 

    @Operation(
            summary = "Fetch Account Details REST API",
            description = "REST API to fetch Customer  details based on Customer Reference"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam
                                                               String customerReferance) {
        CustomerDto customerDto = iCustomerService.getCustomer(customerReferance);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }


}
