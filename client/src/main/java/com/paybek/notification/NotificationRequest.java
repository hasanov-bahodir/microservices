package com.paybek.notification;
// Bahodir Hasanov 9/22/2022 6:20 PM

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerEmail,
        String message
        ) {

}
