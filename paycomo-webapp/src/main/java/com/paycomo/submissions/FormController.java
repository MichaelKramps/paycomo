package com.paycomo.submissions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {
    @PostMapping("/testFormSubmission")
    @ResponseBody
    public AuthorizationResponse test(@RequestBody AuthorizationRequest request){
        AuthorizationResponse response = new AuthorizationResponse();
        response.setResponse(request.getRequest());
        return response;
    }
}
