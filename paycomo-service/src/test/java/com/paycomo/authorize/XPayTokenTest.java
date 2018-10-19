package com.paycomo.authorize;

import com.paycomo.domain.AuthorizationRequest;
import org.junit.Test;

import static org.junit.Assert.*;

public class XPayTokenTest {
    @Test
    public void thisTest(){
        XPayToken generate = new XPayToken();
        AuthorizationRequest request = new AuthorizationRequest();
        request.setRequest("Hello, Kate");
        String xPayToken = generate.generateXPayToken("/test?apiKey=xxxyyyzzz", request, "abcdefg");
        System.out.println(xPayToken);
    }
}