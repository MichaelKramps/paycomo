package com.paycomo.authorize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paycomo.domain.authorize.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class CyberSourceClientTest {

    CyberSourceClient cyberSourceClient;

    @Before
    public void testPrep(){
        ObjectMapper objectMapper = new ObjectMapper();
        cyberSourceClient = new CyberSourceClient(new RestTemplate(), objectMapper, new XPayToken(objectMapper));
    }

    @Test
    public void requestAuthorizationWorksWithValidRequest() {
        AuthorizationResponse authorizationResponse = cyberSourceClient.requestAuthorization(getValidRequest());

        assert(authorizationResponse.getStatus().equals("AUTHORIZED"));
    }

    @Test
    public void requestFlexibleTokenKey() {
        assert(false);
    }

    @Test
    public void cybersourceAuthorizedPostRequest() {
        assert(false);
    }

    private AuthorizationRequest getValidRequest() {
        AuthorizationRequest request = new AuthorizationRequest();

        ClientReferenceInformation clientReferenceInformation = new ClientReferenceInformation();
        ProcessingInformation processingInformation = new ProcessingInformation();
        AggregatorInformation aggregatorInformation = new AggregatorInformation();
        OrderInformation orderInformation = new OrderInformation();
        PaymentInformation paymentInformation = new PaymentInformation();

        //clientReferenceInformation.setCode("TC50171_3");

        //processingInformation.setCommerceIndicator("internet");

        SubMerchant subMerchant = new SubMerchant();
        subMerchant.setCardAcceptorId("1234567890");
        subMerchant.setCountry("US");
        subMerchant.setPhoneNumber("650-432-0000");
        subMerchant.setAddress1("900 Metro Center");
        subMerchant.setPostalCode("94404-2775");
        subMerchant.setLocality("Foster City");
        subMerchant.setName("Visa Inc.");
        subMerchant.setAdministrativeArea("CA");
        subMerchant.setRegion("PEN");
        subMerchant.setEmail("joke@joke.com");
        aggregatorInformation.setSubMerchant(subMerchant);
        aggregatorInformation.setAggregatorId("123456789");
        aggregatorInformation.setName("V-Internatio");

        PersonAddress billTo = new PersonAddress();
        billTo.setCountry("US");
        billTo.setLastName("VDP");
        //billTo.setAddress2("Address 2");
        billTo.setAddress1("201 S. Division St.");
        billTo.setPostalCode("48104-2201");
        billTo.setLocality("Ann Arbor");
        billTo.setAdministrativeArea("MI");
        billTo.setFirstName("First");
        //billTo.setPhoneNumber("822-687-0987");
        //billTo.setDistrict("MI");
        //billTo.setBuildingNumber("123");
        //billTo.setCompany("Visa");
        billTo.setEmail("test@visa.com");
        orderInformation.setBillTo(billTo);
        AmountDetails amountDetails = new AmountDetails();
        amountDetails.setTotalAmount("102.21");
        amountDetails.setCurrency("USD");
        orderInformation.setAmountDetails(amountDetails);

        Card card = new Card();
        card.setExpirationYear("2031");
        card.setExpirationMonth("12");
        card.setNumber("5555555555554444");
        card.setSecurityCode("123");
        //card.setType("002");
        paymentInformation.setCard(card);

        request.setClientReferenceInformation(clientReferenceInformation);
        request.setProcessingInformation(processingInformation);
        request.setAggregatorInformation(aggregatorInformation);
        request.setOrderInformation(orderInformation);
        request.setPaymentInformation(paymentInformation);

        return request;
    }
}