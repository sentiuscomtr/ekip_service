package com.hackathon.ilac.dao.rest.rest;

import com.hackathon.ilac.config.helper.RestXMLClient;
import com.hackathon.ilac.dao.rest.url.SmsURL;
import com.hackathon.ilac.model.xmlElement.SMS;
import com.hackathon.ilac.properties.SmsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmsDAO {
    @Autowired
    private SmsProperties smsProperties;
    @Autowired
    private RestXMLClient<SMS> smsRest;
    public void send(SMS sms){
        sms.setUsername(smsProperties.getUsername());
        sms.setPassword(smsProperties.getPassword());
        sms.setHeader(smsProperties.getHeader());
        sms.setValidity(smsProperties.getValidity());
        smsRest.setURL(SmsURL.SEND_SMS);
        smsRest.post(sms);
    }
}
