package com.hackathon.ilac.config;

import com.hackathon.ilac.config.helper.RestXMLClient;
import com.hackathon.ilac.model.xmlElement.SMS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestXMLConfig {

    @Bean
    public RestXMLClient<SMS> getMasgsmRest(){
        RestXMLClient<SMS> smsRestXMLClient=new RestXMLClient<>();
        return smsRestXMLClient;
    }
}
