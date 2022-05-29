package com.hackathon.ilac.config.helper;

import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Arrays;

public class RestXMLClient<T> {
    private final Logger LOGGER= LoggerFactory.getLogger(RestXMLClient.class);
    @Setter
    private String URL;
    public String post(T body){
        RestTemplate template=new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setAcceptCharset(Arrays.asList(Charset.forName("UTF-8")));

        HttpEntity<T> req=new HttpEntity<T>(body,headers);
        try {
            ResponseEntity<String> res=template.exchange(URL, HttpMethod.POST,req,String.class);
            LOGGER.info("Sent Request");
            LOGGER.warn("Response:"+res.getBody());
            return res.getBody();
        }catch (Exception e){
            return "ERROR";
        }
    }
}