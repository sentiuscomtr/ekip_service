package com.hackathon.ilac.controller;

import com.hackathon.ilac.model.dto.request.MedicineRequest;
import com.hackathon.ilac.model.dto.request.RecycleMedicineRequest;
import com.hackathon.ilac.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/kbb")
public class KBBController {
    @Autowired
    private MedicineService medicineService;

    @PostMapping("/medicine")
    public ResponseEntity<?> saveMedicine(@Valid @RequestBody MedicineRequest request){
        medicineService.saveMedicine(request);
        return ResponseEntity.ok("SAVED");
    }

    @PostMapping("/recycle")
    public ResponseEntity<?> addRecycle(@RequestBody RecycleMedicineRequest request){
        medicineService.addRecycle(request);
        return ResponseEntity.ok("ADDED");
    }
}
