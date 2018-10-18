package com.paycomo.authorize;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class XPayToken {
    public String generateXPayToken(String urlPath, Object body, String sharedKey){
        long unixTime = System.currentTimeMillis() / 1000L;
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(body);

        String message = unixTime + urlPath + requestBody;

        String token = "xv2:" + unixTime + sha256_HMAC(sharedKey, message);
        return token;
    }

    private String sha256_HMAC(String key, String message){
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        String hash = Base64.encodeBase64String(sha256_HMAC.doFinal(message.getBytes()));
        return hash;
    }
}
