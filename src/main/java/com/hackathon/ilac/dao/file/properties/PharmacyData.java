package com.hackathon.ilac.dao.file.properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PharmacyData {
    @JsonProperty
    private List<PharmacyJson> features;
}
