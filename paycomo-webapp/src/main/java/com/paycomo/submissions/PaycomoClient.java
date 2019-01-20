package com.paycomo.submissions;

import com.paycomo.domain.authorize.AuthorizationRequest;
import com.paycomo.domain.authorize.AuthorizationResponse;
import com.paycomo.domain.stripe.ChargeRequest;
import com.paycomo.domain.tokenize.TokenizedCardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

public class PaycomoClient {
    @Autowired
    private RestTemplate client;

    @Autowired
    @Qualifier("paycomoServiceLocation")
    private String paycomoServiceLocation;

    public PaycomoClient(RestTemplate restTemplate, String paycomoServiceLocation){
        this.client = restTemplate;
        this.paycomoServiceLocation = paycomoServiceLocation;
    }

    public AuthorizationResponse requestAuthorization(AuthorizationRequest request){
        return client.postForObject(paycomoServiceLocation + "/requestAuthorization", request, AuthorizationResponse.class);
    }

    public AuthorizationResponse requestSale(AuthorizationRequest request) {
        return client.postForObject(paycomoServiceLocation + "/requestSale", request, AuthorizationResponse.class);
    }

    public TokenizedCardResponse requestTokenizedCard(AuthorizationRequest request){
        return client.postForObject(paycomoServiceLocation + "/requestTokenizedCard", request, TokenizedCardResponse.class);
    }

    public String requestStripeCharge(ChargeRequest request){
        return client.postForObject(paycomoServiceLocation + "/stripeCharge", request, String.class);
    }
}
