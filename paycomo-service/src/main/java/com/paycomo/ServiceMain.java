package com.paycomo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paycomo.authorize.CyberSourceClient;
import com.paycomo.authorize.XPayToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
@SpringBootApplication
public class ServiceMain {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServiceMain.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public XPayToken xPayToken() {
        return new XPayToken(objectMapper());
    }

    @Bean(name="authorizationPath")
    public String authorizationPath() {
        return "v2/payments";
    }

    @Bean(name="sharedSecret")
    public String sharedSecret() {
        return "9$D3{wKT-DIgOSj$bar/mIv1#$x2wd1RIOf2QTLH";
    }

    @Bean(name="apiKey")
    public String apiKey() {
        return "YBGSOBWEFWM92WLQUWLU21J4gj3HWPDvR5BoZToCYSUypqEsY";
    }

    @Bean(name="queryString")
    public String queryString() {
        return "apikey=" + apiKey();
    }

    @Bean
    public CyberSourceClient cyberSourceClient(){
        return new CyberSourceClient(restTemplate(), objectMapper(), xPayToken());
    }
}
