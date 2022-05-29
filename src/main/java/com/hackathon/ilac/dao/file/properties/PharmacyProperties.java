package com.hackathon.ilac.dao.file.properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PharmacyProperties {
    @JsonProperty
    private String ADI;
}
