package com.paybek;
// Bahodir Hasanov 9/20/2022 12:28 PM

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private String firstName;
    private String lastName;
    private String email;
}
