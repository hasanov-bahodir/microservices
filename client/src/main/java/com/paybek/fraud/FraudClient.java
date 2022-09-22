package com.paybek.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Bahodir Hasanov 9/22/2022 4:36 PM
@FeignClient(value = "fraud",path ="api/v1/fraud-check/" )
public interface FraudClient {
    @GetMapping(path = "{customerId}")
    FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId);
}
