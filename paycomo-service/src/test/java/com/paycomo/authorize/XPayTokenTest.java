package com.paycomo.authorize;

import com.paycomo.domain.AuthorizationRequest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.security.SignatureException;

public class XPayTokenTest {
    RestTemplate client;
    String apiKey = "YBGSOBWEFWM92WLQUWLU21J4gj3HWPDvR5BoZToCYSUypqEsY";
    String queryString = "apikey=" + apiKey;
    String sharedSecret = "9$D3{wKT-DIgOSj$bar/mIv1#$x2wd1RIOf2QTLH";


    @Before
    public void createStuff(){
        client = new RestTemplate();
    }

    @Test
    public void paymentCanBeAuthorized(){
        String resourcePath = "v2/payments";
        String requestBody = "{\"clientReferenceInformation\":{\"code\":\"TC50171_3\"},\"processingInformation\":{\"commerceIndicator\":\"internet\"},\"aggregatorInformation\":{\"subMerchant\":{\"cardAcceptorID\":\"1234567890\",\"country\":\"US\",\"phoneNumber\":\"650-432-0000\",\"address1\":\"900 Metro Center\",\"postalCode\":\"94404-2775\",\"locality\":\"Foster City\",\"name\":\"Visa Inc\",\"administrativeArea\":\"CA\",\"region\":\"PEN\",\"email\":\"test@cybs.com\"},\"name\":\"V-Internatio\",\"aggregatorID\":\"123456789\"},\"orderInformation\":{\"billTo\":{\"country\":\"US\",\"lastName\":\"VDP\",\"address2\":\"Address 2\",\"address1\":\"201 S. Division St.\",\"postalCode\":\"48104-2201\",\"locality\":\"Ann Arbor\",\"administrativeArea\":\"MI\",\"firstName\":\"RTS\",\"phoneNumber\":\"999999999\",\"district\":\"MI\",\"buildingNumber\":\"123\",\"company\":\"Visa\",\"email\":\"test@cybs.com\"},\"amountDetails\":{\"totalAmount\":\"102.21\",\"currency\":\"USD\"}},\"paymentInformation\":{\"card\":{\"expirationYear\":\"2031\",\"number\":\"5555555555554444\",\"securityCode\":\"123\",\"expirationMonth\":\"12\",\"type\":\"002\"}}}";
        try {
            String xPayToken = XPayToken.generateXPayToken(resourcePath, queryString, requestBody, sharedSecret);
            System.out.println(xPayToken);

            String url = "https://sandbox.api.visa.com/cybersource/" + resourcePath;
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("apikey", apiKey);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("x-pay-token", xPayToken);
            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

            String result = client.exchange(builder.toUriString(), HttpMethod.POST, requestEntity, String.class).toString();

            System.out.println(result);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}