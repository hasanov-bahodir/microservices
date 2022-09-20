package com.paybek;
// Bahodir Hasanov 9/20/2022 12:28 PM

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity()
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_id_sequence",
            sequenceName = "customer_id_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
