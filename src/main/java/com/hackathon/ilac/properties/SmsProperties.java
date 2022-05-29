package com.hackathon.ilac.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsProperties {
    @Getter
    @Value("${corap.masgsm.username}")
    private String username;
    @Getter
    @Value("${corap.masgsm.password}")
    private String password;
    @Getter
    @Value("${corap.masgsm.header}")
    private String header;
    @Getter
    @Value("${corap.masgsm.validity}")
    private String validity;
}
