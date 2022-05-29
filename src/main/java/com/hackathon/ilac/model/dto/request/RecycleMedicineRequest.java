package com.hackathon.ilac.model.dto.request;

import com.hackathon.ilac.model.enums.RecycleType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecycleMedicineRequest{
    private Long medicineId;
    private int number;
    private RecycleType type;
    private LocalDateTime skt;
}
