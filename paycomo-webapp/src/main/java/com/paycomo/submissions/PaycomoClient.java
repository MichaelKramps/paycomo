package com.paycomo.submissions;

import com.paycomo.domain.AuthorizationRequest;
import com.paycomo.domain.AuthorizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class PaycomoClient {
    @Autowired
    private RestTemplate client;

    public PaycomoClient(RestTemplate restTemplate){
        this.client = restTemplate;
    }

    public AuthorizationResponse requestAuthorization(AuthorizationRequest request){
        return client.postForObject("https://localhost:8090/requestAuthorization", request, AuthorizationResponse.class);
    }
}
