package com.paycomo.submissions;

import com.paycomo.domain.authorize.TokenizedCard;
import com.paycomo.domain.tokenize.FlexibleTokenKeyResponse;
import com.paycomo.domain.tokenize.TokenizedCardRequest;
import com.paycomo.domain.tokenize.TokenizedCardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paycomo.domain.authorize.AuthorizationResponse;
import com.paycomo.domain.authorize.AuthorizationRequest;

@Controller
public class FormController {
    @Autowired
    private PaycomoClient client;

    @PostMapping("/requestAuthorization")
    @ResponseBody
    public AuthorizationResponse requestAuthorization(@RequestBody AuthorizationRequest request){
        return client.requestAuthorization(request);
    }

    @PostMapping("/requestSale")
    @ResponseBody
    public AuthorizationResponse requestSale(@RequestBody AuthorizationRequest request){
        return client.requestSale(request);
    }

    @GetMapping("/requestFlexibleTokenKey")
    @ResponseBody
    public FlexibleTokenKeyResponse requestSale(){
        return client.requestFlexibleTokenKey();
    }
}
