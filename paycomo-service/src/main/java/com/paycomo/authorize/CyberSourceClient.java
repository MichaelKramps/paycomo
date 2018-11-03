package com.paycomo.authorize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paycomo.domain.AuthorizationRequest;
import com.paycomo.domain.AuthorizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class CyberSourceClient {
    @Autowired
    private RestTemplate client;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private XPayToken xPayToken;

    @Autowired
    @Qualifier("apiKey")
    private String apiKey;

    @Autowired
    @Qualifier("authorizationPath")
    private String authorizationPath;

    @Autowired
    @Qualifier("sharedSecret")
    private String sharedSecret;

    @Autowired
    @Qualifier("queryString")
    private String queryString;

    public CyberSourceClient(RestTemplate restTemplate, ObjectMapper mapper, XPayToken xPayToken){
        this.client = restTemplate;
        this.mapper = mapper;
        this.xPayToken = xPayToken;
    }

    public AuthorizationResponse requestAuthorization(AuthorizationRequest request){
        try{
            String token = xPayToken.generateXPayToken(authorizationPath, queryString, request, sharedSecret);

            System.out.println(token);
            System.out.println(mapper.writeValueAsString(request));

            String url = "https://sandbox.api.visa.com/cybersource/" + authorizationPath;
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("apikey", apiKey);

            System.out.println(builder.toUriString());

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("x-pay-token", token);
            HttpEntity<AuthorizationRequest> requestEntity = new HttpEntity<>(request, headers);

            String result = client.exchange(builder.toUriString(), HttpMethod.POST, requestEntity, String.class).getBody();

            AuthorizationResponse authorizationResponse = mapper.readValue(result, AuthorizationResponse.class);

            return authorizationResponse;
        } catch (Exception e){
            e.printStackTrace();
            return new AuthorizationResponse();
        }
    }
}
