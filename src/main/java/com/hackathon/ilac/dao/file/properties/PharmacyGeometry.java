package com.hackathon.ilac.dao.file.properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PharmacyGeometry {
    @JsonProperty
    private String type;
    @JsonProperty
    private double[] coordinates;
}
