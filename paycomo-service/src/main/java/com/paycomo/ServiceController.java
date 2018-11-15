package com.paycomo;

import com.paycomo.authorize.CyberSourceClient;
import com.paycomo.domain.authorize.ProcessingInformation;
import com.paycomo.domain.tokenize.*;
import com.paycomo.tokenize.CardDataSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paycomo.domain.authorize.AuthorizationResponse;
import com.paycomo.domain.authorize.AuthorizationRequest;

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

    @PostMapping("/requestTokenizedAuthorization")
    @ResponseBody
    public TokenizedCardResponse requestTokenizedCard(@RequestBody AuthorizationRequest request){
        FlexibleTokenKeyResponse flexibleTokenKeyResponse = client.requestFlexibleTokenKey(new FlexibleTokenKeyRequest());
        String encodedCardNumber = CardDataSerializer.getEncodedCardNumber(flexibleTokenKeyResponse.getDer().getPublicKey(), request.getPaymentInformation().getCard().getNumber());

        TokenizedCardRequest tokenizedCardRequest = new TokenizedCardRequest();
        tokenizedCardRequest.setKeyId(flexibleTokenKeyResponse.getKeyId());
        CardInfo cardInfo = new CardInfo();
        cardInfo.setCardNumber(request.getPaymentInformation().getCard().getNumber());
        cardInfo.setCardExpirationMonth(request.getPaymentInformation().getCard().getExpirationMonth());
        cardInfo.setCardExpirationYear(request.getPaymentInformation().getCard().getExpirationYear());
        // needs to be looked into
        cardInfo.setCardType("001");
        tokenizedCardRequest.setCardInfo(cardInfo);

        TokenizedCardResponse tokenizedCardResponse = client.requestTokenizedCard(tokenizedCardRequest);

        return tokenizedCardResponse;
    }
}
