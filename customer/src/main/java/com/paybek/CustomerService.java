package com.paybek;

import org.springframework.stereotype.Service;

@Service
public record CustomerService() {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // TODO: 9/20/2022 check if email valid
        // TODO: 9/20/2022 check if email not taken
        // TODO: 9/20/2022 store customer in db

    }
}
