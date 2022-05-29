package com.hackathon.ilac.model.dto.response;

import lombok.Data;

@Data
public class MedicineResponse {
    private Long id;
    private String name;
    private int size;
}
