package com.paycomo.authorize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paycomo.domain.AuthorizationRequest;
import com.paycomo.domain.ClientReferenceInformation;
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
    XPayToken xPayToken;
    String apiKey = "YBGSOBWEFWM92WLQUWLU21J4gj3HWPDvR5BoZToCYSUypqEsY";
    String queryString = "apikey=" + apiKey;
    String sharedSecret = "9$D3{wKT-DIgOSj$bar/mIv1#$x2wd1RIOf2QTLH";


    @Before
    public void createStuff(){
        client = new RestTemplate();
        xPayToken = new XPayToken(new ObjectMapper());
    }

    @Test
    public void paymentCanBeAuthorized(){
        String resourcePath = "v2/payments";
        AuthorizationRequest request = new AuthorizationRequest();
        try {
            String token = xPayToken.generateXPayToken(resourcePath, queryString, request, sharedSecret);

            String url = "https://sandbox.api.visa.com/cybersource/" + resourcePath;
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("apikey", apiKey);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("x-pay-token", token);
            HttpEntity<AuthorizationRequest> requestEntity = new HttpEntity<>(new AuthorizationRequest(), headers);

            String result = client.exchange(builder.toUriString(), HttpMethod.POST, requestEntity, String.class).toString();

            assert(result.contains("Success"));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private AuthorizationRequest getValidRequest() {
        AuthorizationRequest request = new AuthorizationRequest();

        ClientReferenceInformation clientReferenceInformation = new ClientReferenceInformation();

        request.setClientReferenceInformation();

        return request;
    }
}