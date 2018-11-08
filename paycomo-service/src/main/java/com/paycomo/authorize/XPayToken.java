package com.paycomo.authorize;

//import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SignatureException;

@Component
public class XPayToken {
    @Autowired
    private ObjectMapper mapper;

    public XPayToken(ObjectMapper mapper){
        this.mapper = mapper;
    }

    public String generateXPayToken(String resourcePath, String queryString, String requestBody, String sharedSecret) throws SignatureException {
        try {
            String timestamp = timeStamp();
            String beforeHash = timestamp + resourcePath + queryString + requestBody;
            String hash = hmacSha256Digest(beforeHash, sharedSecret);
            String token = "xv2:" + timestamp + ":" + hash;
            return token;
        } catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    public String generateXPayToken(String resourcePath, String queryString, Object request, String sharedSecret) throws SignatureException {
        try {
            return generateXPayToken(resourcePath, queryString, mapper.writeValueAsString(request), sharedSecret);
        } catch (JsonProcessingException e){
            e.printStackTrace();
            return "";
        }
    }

    private String timeStamp() {
        return String.valueOf(System.currentTimeMillis()/ 1000L);
    }

    String hmacSha256Digest(String data, String sharedSecret)
            throws Exception {
        return getDigest("HmacSHA256", sharedSecret, data, true);
    }

    private String getDigest(String algorithm, String sharedSecret, String data,  boolean toLower) throws SignatureException {
        try {
            Mac sha256HMAC = Mac.getInstance(algorithm);
            SecretKeySpec secretKey = new SecretKeySpec(sharedSecret.getBytes(StandardCharsets.UTF_8), algorithm);
            sha256HMAC.init(secretKey);

            byte[] hashByte = sha256HMAC.doFinal(data.getBytes(StandardCharsets.UTF_8));
            String hashString = toHex(hashByte);

            return toLower ? hashString.toLowerCase() : hashString;
        } catch (Exception e) {
            throw new SignatureException(e);
        }
    }

    private String toHex(byte[] bytes) {
        BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "X", bi);
    }
}
