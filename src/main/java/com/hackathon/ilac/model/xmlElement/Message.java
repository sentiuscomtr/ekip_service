package com.hackathon.ilac.model.xmlElement;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class Message {
    @XmlElement(name="gsm")
    private GSM gsm;
    @XmlElement(name="msg")
    private String msg;

}
