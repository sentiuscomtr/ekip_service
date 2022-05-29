package com.hackathon.ilac.model.xmlElement;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "sms")
@XmlAccessorType(XmlAccessType.FIELD)
public class SMS {
    @XmlElement(name="username")
    private String username;
    @XmlElement(name="password")
    private String password;
    @XmlElement(name="header")
    private String header;
    @XmlElement(name="validity")
    private String validity;
    @XmlElement(name="message")
    private Message message;
}
