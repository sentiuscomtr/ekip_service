package com.hackathon.ilac.service;

import com.hackathon.ilac.dao.rest.rest.SmsDAO;
import com.hackathon.ilac.model.xmlElement.GSM;
import com.hackathon.ilac.model.xmlElement.Message;
import com.hackathon.ilac.model.xmlElement.SMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    @Autowired
    private SmsDAO smsDAO;

    public void sendPassword(String phone,String password){
        smsDAO.send(create(phone,buildPasswordMsg(password)));
    }
    private SMS create(String no, String msg){
        GSM gsm=new GSM();
        gsm.setNo(no);
        Message message=new Message();
        message.setGsm(gsm);
        message.setMsg(msg);
        SMS sms=new SMS();
        sms.setHeader("");
        sms.setPassword("");
        sms.setUsername("");
        sms.setValidity("");
        sms.setMessage(message);
        return sms;
    }
    private String buildPasswordMsg(String code){
        return "SIFRE:"+code;
    }
}
