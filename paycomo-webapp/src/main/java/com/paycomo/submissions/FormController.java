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

    @PostMapping("/testFormSubmission")
    @ResponseBody
    public AuthorizationResponse test(@RequestBody AuthorizationRequest request){
        System.out.println("Kramps: " + request.getRequest());
        return client.restTest(request);
    }
}
