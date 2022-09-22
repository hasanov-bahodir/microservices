package com.paybek.customer;

import com.paybek.fraud.FraudCheckResponse;
import com.paybek.fraud.FraudClient;
import com.paybek.notification.NotificationClient;
import com.paybek.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // TODO: 9/20/2022 check if email valid
        // TODO: 9/20/2022 check if email not taken
        customerRepository.saveAndFlush(customer);
        // TODO: 9/22/2022 check is customer fraudster?
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        // TODO: 9/22/2022 make it async i.e add to queue?
        notificationClient.sendNotification(new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Paybek", customer.getFirstName())
        ));

    }
}
