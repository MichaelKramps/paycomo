package com.paycomo.authorize;

import org.junit.Test;

import java.security.SignatureException;

public class XPayTokenTest {
    @Test
    public void canAuthenticateWithVisaApi(){
        try {
            String resourcePath = "helloworld";
            String queryString = "apikey=YBGSOBWEFWM92WLQUWLU21J4gj3HWPDvR5BoZToCYSUypqEsY";
            String sharedSecret = "9$D3{wKT-DIgOSj$bar/mIv1#$x2wd1RIOf2QTLH";
            String xPayToken = XPayToken.generateXPayToken(resourcePath, queryString, "", sharedSecret);

            HttpClient client 
        } catch (SignatureException e){
            e.printStackTrace();
        }
    }
}