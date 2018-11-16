package com.paycomo.domain;

import com.paycomo.domain.authorize.AuthorizationRequest;
import com.paycomo.domain.authorize.AuthorizationResponse;
import com.paycomo.domain.authorize.Card;
import com.paycomo.domain.authorize.PaymentInformation;
import org.junit.jupiter.api.Test;

public class AuthorizationRequestTest {

    @Test
    public void visaReturnsVisaType() {
        AuthorizationRequest authorizationRequest = new AuthorizationRequest();
        PaymentInformation paymentInformation = new PaymentInformation();
        Card card = new Card();
        card.setNumber("4111111111111111");

        paymentInformation.setCard(card);
        authorizationRequest.setPaymentInformation(paymentInformation);

        String cardType = authorizationRequest.generateCardType();

        assert(cardType == "001");
    }

    @Test
    public void mastercardReturnsMastercardType() {
        AuthorizationRequest authorizationRequest = new AuthorizationRequest();
        PaymentInformation paymentInformation = new PaymentInformation();
        Card card = new Card();
        card.setNumber("5500000000000004");

        paymentInformation.setCard(card);
        authorizationRequest.setPaymentInformation(paymentInformation);

        String cardType = authorizationRequest.generateCardType();

        assert(cardType == "002");
    }

    @Test
    public void americanExpressReturnsAmericanExpressType() {
        AuthorizationRequest authorizationRequest = new AuthorizationRequest();
        PaymentInformation paymentInformation = new PaymentInformation();
        Card card = new Card();
        card.setNumber("340000000000009");

        paymentInformation.setCard(card);
        authorizationRequest.setPaymentInformation(paymentInformation);

        String cardType = authorizationRequest.generateCardType();

        assert(cardType == "003");
    }

    @Test
    public void discoverReturnsDiscoverType() {
        AuthorizationRequest authorizationRequest = new AuthorizationRequest();
        PaymentInformation paymentInformation = new PaymentInformation();
        Card card = new Card();
        card.setNumber("6011000000000004");

        paymentInformation.setCard(card);
        authorizationRequest.setPaymentInformation(paymentInformation);

        String cardType = authorizationRequest.generateCardType();

        assert(cardType == "004");
    }
}
