package com.hackathon.ilac.model.xmlElement;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "gsm")
@XmlAccessorType(XmlAccessType.FIELD)
public class GSM {
    @XmlElement(name="no")
    private String no;

}
