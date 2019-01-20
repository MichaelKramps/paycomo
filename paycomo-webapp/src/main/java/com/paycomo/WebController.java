package com.paycomo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/authorize")
    public String authorize(){
        return "authorizationForm";
    }

    @GetMapping("/stripe")
    public String stripe(){
        return "stripe";
    }

}
