package com.paycomo.authorize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paycomo.domain.authorize.AuthorizationRequest;
import com.paycomo.domain.authorize.AuthorizationResponse;
import com.paycomo.domain.tokenize.FlexibleTokenKeyRequest;
import com.paycomo.domain.tokenize.FlexibleTokenKeyResponse;
import com.paycomo.domain.tokenize.TokenizedCardRequest;
import com.paycomo.domain.tokenize.TokenizedCardResponse;
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
    @Qualifier("basePath")
    private String basePath;

    @Autowired
    @Qualifier("authorizationPath")
    private String authorizationPath;

    @Autowired
    @Qualifier("flexibleTokenKeyPath")
    private String flexibleTokenKeyPath;

    @Autowired
    @Qualifier("tokenizedCardPath")
    private String tokenizedCardPath;

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

    // currently used in unit tests
    public CyberSourceClient(
            RestTemplate restTemplate,
            ObjectMapper mapper,
            XPayToken xPayToken,
            String apiKey,
            String authorizationPath,
            String flexibleTokenKeyPath,
            String sharedSecret,
            String queryString)
    {
        this.client = restTemplate;
        this.mapper = mapper;
        this.xPayToken = xPayToken;
        this.apiKey = apiKey;
        this.authorizationPath = authorizationPath;
        this.flexibleTokenKeyPath = flexibleTokenKeyPath;
        this.sharedSecret = sharedSecret;
        this.queryString = queryString;
    }

    public AuthorizationResponse requestAuthorization(AuthorizationRequest request){
        try{
            String response = cybersourceAuthorizedPostRequest(authorizationPath, request);
            AuthorizationResponse authorizationResponse = mapper.readValue(response, AuthorizationResponse.class);

            return authorizationResponse;
        } catch (Exception e){
            e.printStackTrace();
            return new AuthorizationResponse();
        }
    }

    public FlexibleTokenKeyResponse requestFlexibleTokenKey(FlexibleTokenKeyRequest request){
        try{
            String response = cybersourceAuthorizedPostRequest(flexibleTokenKeyPath, request);
            FlexibleTokenKeyResponse flexibleTokenKeyResponse = mapper.readValue(response, FlexibleTokenKeyResponse.class);

            return flexibleTokenKeyResponse;
        } catch (Exception e){
            e.printStackTrace();
            return new FlexibleTokenKeyResponse();
        }
    }

    public TokenizedCardResponse requestTokenizedCard(TokenizedCardRequest request){
        try{
            String response = cybersourceUnauthorizedPostRequest(tokenizedCardPath, request);
            TokenizedCardResponse tokenizedCardResponse = mapper.readValue(response, TokenizedCardResponse.class);

            return tokenizedCardResponse;
        } catch (Exception e){
            e.printStackTrace();
            return new TokenizedCardResponse();
        }
    }

    private String cybersourceUnauthorizedPostRequest(String path, Object request) {
        String url = basePath + path;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("apikey", apiKey);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(request, headers);

        String result = client.exchange(builder.toUriString(), HttpMethod.POST, requestEntity, String.class).getBody();

        return result;
    }

    public String cybersourceAuthorizedPostRequest(String path, Object request){
        try{
            String token = xPayToken.generateXPayToken(path, queryString, request, sharedSecret);

            System.out.println(token);
            System.out.println(mapper.writeValueAsString(request));

            String url = basePath + path;
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("apikey", apiKey);

            System.out.println(builder.toUriString());

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("x-pay-token", token);
            HttpEntity<Object> requestEntity = new HttpEntity<>(request, headers);

            String result = client.exchange(builder.toUriString(), HttpMethod.POST, requestEntity, String.class).getBody();

            return result;
        } catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
