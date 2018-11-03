package com.paycomo;

import com.paycomo.authorize.CyberSourceClient;
import com.paycomo.domain.ProcessingInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paycomo.domain.AuthorizationResponse;
import com.paycomo.domain.AuthorizationRequest;

@Controller
public class ServiceController {
    @Autowired
    CyberSourceClient client;
    
    @PostMapping("/requestAuthorization")
    @ResponseBody
    public AuthorizationResponse requestAuthorization(@RequestBody AuthorizationRequest request){
        AuthorizationResponse response = client.requestAuthorization(request);
        return response;
    }

    @PostMapping("/requestSale")
    @ResponseBody
    public AuthorizationResponse requestSale(@RequestBody AuthorizationRequest request){
        ProcessingInformation processingInformation = new ProcessingInformation();
        processingInformation.setCapture(true);
        request.setProcessingInformation(processingInformation);
        AuthorizationResponse response = client.requestAuthorization(request);
        return response;
    }
}
