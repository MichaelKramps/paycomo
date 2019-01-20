package com.paycomo;

import com.paycomo.authorize.CyberSourceClient;
import com.paycomo.domain.authorize.ProcessingInformation;
import com.paycomo.domain.stripe.ChargeRequest;
import com.paycomo.domain.tokenize.*;
import com.paycomo.tokenize.CardDataSerializer;
import com.stripe.Stripe;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paycomo.domain.authorize.AuthorizationResponse;
import com.paycomo.domain.authorize.AuthorizationRequest;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ServiceController {
    @Autowired
    CyberSourceClient client;
    
    @PostMapping("/requestAuthorization")
    @ResponseBody
    public AuthorizationResponse requestAuthorization(@RequestBody AuthorizationRequest request){
        AuthorizationResponse response = client.requestAuthorization(request);
        return response;
    }

    @PostMapping("/requestSale")
    @ResponseBody
    public AuthorizationResponse requestSale(@RequestBody AuthorizationRequest request){
        ProcessingInformation processingInformation = new ProcessingInformation();
        processingInformation.setCapture(true);
        request.setProcessingInformation(processingInformation);
        AuthorizationResponse response = client.requestAuthorization(request);
        return response;
    }

    @PostMapping("/requestTokenizedCard")
    @ResponseBody
    public TokenizedCardResponse requestTokenizedCard(@RequestBody AuthorizationRequest request){
        FlexibleTokenKeyResponse flexibleTokenKeyResponse = client.requestFlexibleTokenKey(new FlexibleTokenKeyRequest());
        String encodedCardNumber = CardDataSerializer.getEncodedCardNumber(flexibleTokenKeyResponse.getDer().getPublicKey(), request.getPaymentInformation().getCard().getNumber());

        TokenizedCardRequest tokenizedCardRequest = new TokenizedCardRequest();
        tokenizedCardRequest.setKeyId(flexibleTokenKeyResponse.getKeyId());
        CardInfo cardInfo = new CardInfo();
        cardInfo.setCardNumber(encodedCardNumber);
        cardInfo.setCardExpirationMonth(request.getPaymentInformation().getCard().getExpirationMonth());
        cardInfo.setCardExpirationYear(request.getPaymentInformation().getCard().getExpirationYear());
        cardInfo.setCardType(request.generateCardType()); // looks at the card number to determine the type of card being used
        tokenizedCardRequest.setCardInfo(cardInfo);

        TokenizedCardResponse tokenizedCardResponse = client.requestTokenizedCard(tokenizedCardRequest);

        return tokenizedCardResponse;
    }

    @PostMapping("/stripeCharge")
    @ResponseBody
    public String requestStripeCharge(@RequestBody ChargeRequest request){
        Stripe.apiKey = "sk_test_D6guK1T3Di9EmVWlcJ8JcLOg";

        // Token is created using Checkout or Elements!
        // Get the payment token ID submitted by the form:
        String token = request.getTokenId();

        Map<String, Object> params = new HashMap<>();
        params.put("amount", 999);
        params.put("currency", "usd");
        params.put("description", "Example charge");
        params.put("source", token);
        try {
            Charge charge = Charge.create(params);
            return charge.toString();
        } catch(Exception ignored){
            return "Error occured!";
        }
    }
}
