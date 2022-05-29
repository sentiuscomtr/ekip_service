package com.hackathon.ilac.model.dto.response;

import lombok.Data;

@Data
public class KomekMedicineResponse {
    private Long komekId;
    private String komekName;
    private int number;
    private double lat;
    private double lang;

}
