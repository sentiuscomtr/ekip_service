package com.hackathon.ilac.model.jsonElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DutyPharmacyJson {
    private boolean success;
    private List<DutyPharmacy> result;
}
