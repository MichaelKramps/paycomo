package com.paycomo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/hello")
    public String helloWorld(){
        System.out.println("hello, Michael");
        return "hello";
    }
}
