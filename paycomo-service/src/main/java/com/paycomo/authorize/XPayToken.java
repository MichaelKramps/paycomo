package com.paycomo.authorize;

import com.fasterxml.jackson.databind.ObjectMapper;

public class XPayToken {
    public String generateXPayToken(String urlPath, Object body, String sharedKey){
        long unixTime = System.currentTimeMillis() / 1000L;
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(body);

        String message = unixTime + urlPath + requestBody;

        String token = "xv2:" + unixTime + sha256_HMAC(sharedKey, message);
        return token;
    }

    private String sha256_HMAC(String key, String payload){
        return "";
    }
}
