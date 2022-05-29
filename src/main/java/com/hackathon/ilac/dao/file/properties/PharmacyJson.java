package com.hackathon.ilac.dao.file.properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PharmacyJson {
    @JsonProperty
    private PharmacyGeometry geometry;
    @JsonProperty
    private PharmacyProperties properties;
    @JsonProperty
    private String type;
}
