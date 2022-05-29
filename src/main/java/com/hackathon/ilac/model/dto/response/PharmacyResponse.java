package com.hackathon.ilac.model.dto.response;

import lombok.Data;

@Data
public class PharmacyResponse {
    private Long id;
    private String name;
    private double lat;
    private double lang;
}
