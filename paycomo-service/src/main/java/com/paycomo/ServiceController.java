package com.paycomo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paycomo.domain.AuthorizationResponse;
import com.paycomo.domain.AuthorizationRequest;

@Controller
public class ServiceController {
    
    @PostMapping("/test")
    @ResponseBody
    public AuthorizationResponse test(@RequestBody AuthorizationRequest request){
        AuthorizationResponse response = new AuthorizationResponse();
        response.setResponse(request.getRequest());
        return response;
    }
}
