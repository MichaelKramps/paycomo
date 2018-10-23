package com.paycomo.authorize;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.security.SignatureException;

public class XPayTokenTest {
    @Test
    public void canAuthenticateWithVisaApi(){
        try {
//            String resourcePath = "helloworld";
//            String queryString = "apikey=YBGSOBWEFWM92WLQUWLU21J4gj3HWPDvR5BoZToCYSUypqEsY";
//            String sharedSecret = "9$D3{wKT-DIgOSj$bar/mIv1#$x2wd1RIOf2QTLH";
//            String xPayToken = XPayToken.generateXPayToken(resourcePath, queryString, "", sharedSecret);
//
//
//
//            RestTemplate client = new RestTemplate();
//            String url = "https://sandbox.api.visa.com/vdp/helloworld?" + queryString;
//            HttpHeaders headers = new HttpHeaders();
//            headers.set("x-pay-token", xPayToken);
//            HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
//            String message = client.exchange(url, HttpMethod.GET, entity, String.class).getBody();
//
//            System.out.println(message);
//
//            //assert("helloworld".equals(message.message));
//        } catch (SignatureException e){
//            e.printStackTrace();
//        }
    }

    private class HelloResponse{
        String timestamp;
        String message;
    }
}