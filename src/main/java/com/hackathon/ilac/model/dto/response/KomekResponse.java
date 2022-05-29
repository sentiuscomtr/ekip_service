package com.hackathon.ilac.model.dto.response;


import lombok.Data;

@Data
public class KomekResponse {
    private Long id;
    private String name;
    private String city;
    private double lat;
    private double lang;
}
