package com.paycomo.authorize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paycomo.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class XPayTokenTest {
    RestTemplate client;
    ObjectMapper mapper;
    XPayToken xPayToken;
    String apiKey = "YBGSOBWEFWM92WLQUWLU21J4gj3HWPDvR5BoZToCYSUypqEsY";
    String queryString = "apikey=" + apiKey;
    String sharedSecret = "9$D3{wKT-DIgOSj$bar/mIv1#$x2wd1RIOf2QTLH";


    @Before
    public void testPrep(){
        client = new RestTemplate();
        mapper = new ObjectMapper();
        xPayToken = new XPayToken(this.mapper);
    }

    @Test
    public void paymentCanBeAuthorized(){
        String resourcePath = "v2/payments";
        AuthorizationRequest request = getValidRequest();
        try {
            String token = xPayToken.generateXPayToken(resourcePath, queryString, request, sharedSecret);

            String url = "https://sandbox.api.visa.com/cybersource/" + resourcePath;
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("apikey", apiKey);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("x-pay-token", token);
            HttpEntity<AuthorizationRequest> requestEntity = new HttpEntity<>(request, headers);

            String result = client.exchange(builder.toUriString(), HttpMethod.POST, requestEntity, String.class).getBody();

            AuthorizationResponse authorizationResponse = mapper.readValue(result, AuthorizationResponse.class);

            assert(authorizationResponse.getStatus().equals("AUTHORIZED"));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void digestReturnsExpectedResultWithHmacSHA256(){
        String sharedSecret = "secret";
        String data = "{}";
        String expected = "3569516392125be33b0eeb92a12b49c9907d1d8977a0a91fbb527306523a2030";

        try {
            String result = xPayToken.hmacSha256Digest(sharedSecret, data);
            assert(expected.equals(result));
        } catch (Exception e){

        }
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
        billTo.setAddress2("Address 2");
        billTo.setAddress1("201 S. Division St.");
        billTo.setPostalCode("48104-2201");
        billTo.setLocality("Ann Arbor");
        billTo.setAdministrativeArea("MI");
        billTo.setFirstName("First");
        //billTo.setPhoneNumber("822-687-0987");
        billTo.setDistrict("MI");
        billTo.setBuildingNumber("123");
        billTo.setCompany("Visa");
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