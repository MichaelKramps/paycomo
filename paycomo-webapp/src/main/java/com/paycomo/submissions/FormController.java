package com.paycomo.submissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paycomo.domain.AuthorizationResponse;
import com.paycomo.domain.AuthorizationRequest;

@Controller
public class FormController {
    @Autowired
    private PaycomoClient client;

    @PostMapping("/requestAuthorization")
    @ResponseBody
    public AuthorizationResponse requestAuthorization(@RequestBody AuthorizationRequest request){
        return client.requestAuthorization(request);
    }
}
