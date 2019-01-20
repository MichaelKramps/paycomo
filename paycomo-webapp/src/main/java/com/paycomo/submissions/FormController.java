package com.paycomo.submissions;

import com.paycomo.domain.authorize.TokenizedCard;
import com.paycomo.domain.stripe.ChargeRequest;
import com.paycomo.domain.tokenize.TokenizedCardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paycomo.domain.authorize.AuthorizationResponse;
import com.paycomo.domain.authorize.AuthorizationRequest;

@Controller
public class FormController {
    @Autowired
    private PaycomoClient client;

    @PostMapping("/requestAuthorization")
    @ResponseBody
    public AuthorizationResponse requestAuthorization(@RequestBody AuthorizationRequest request){
        return client.requestAuthorization(request);
    }

    @PostMapping("/requestSale")
    @ResponseBody
    public AuthorizationResponse requestSale(@RequestBody AuthorizationRequest request){
        return client.requestSale(request);
    }

    @PostMapping("/requestTokenizedSale")
    @ResponseBody
    public AuthorizationResponse requestTokenizedSale(@RequestBody AuthorizationRequest request){
        TokenizedCardResponse tokenizedCardResponse = client.requestTokenizedCard(request);

        request.getPaymentInformation().getTokenizedCard().setNumber(tokenizedCardResponse.getToken());

        return client.requestSale(request);
    }

    @PostMapping("/stripe")
    @ResponseBody
    public String stripe(@RequestBody ChargeRequest request){
        // stripeToken=tok_1DuJ72L1S8gXXiuCwUZawoZv&stripeTokenType=card&stripeEmail=mdk989%40gmail.com
        String response = client.requestStripeCharge(request);
        return response;
    }
}
