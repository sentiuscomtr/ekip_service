package com.hackathon.ilac.controller;

import com.hackathon.ilac.model.dto.request.UserLoginRequest;
import com.hackathon.ilac.service.KomekService;
import com.hackathon.ilac.service.MedicineService;
import com.hackathon.ilac.service.PharmacyService;
import com.hackathon.ilac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/home")
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private PharmacyService pharmacyService;

    @Autowired
    private KomekService komekService;

    @Autowired
    private MedicineService medicineService;




    @PostMapping("/login/user")
    ResponseEntity<?> login(@Valid @RequestBody  UserLoginRequest request){
        userService.login(request);
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/pharmacy")
    ResponseEntity<?> pharmacy(){
        return ResponseEntity.ok(pharmacyService.getAllPharmacy());
    }

    @GetMapping("/komek")
    ResponseEntity<?> komek(){
        return ResponseEntity.ok(komekService.getKomeks());
    }

    @GetMapping("/pharmacy/duty")
    ResponseEntity<?> dutyPharmacy(){
        return ResponseEntity.ok(pharmacyService.getDutyPharmacy());
    }

    @GetMapping("/medicine")
    ResponseEntity<?> searchMedicine(@RequestParam("keyword")String keyword, Pageable pageable){
        return ResponseEntity.ok(medicineService.searchMedicine(keyword,pageable));
    }

    @GetMapping("/medicine/{id}")
    ResponseEntity<?> getMedicine(@PathVariable("id")Long id){
        return ResponseEntity.ok(medicineService.getKomekMer(id));
    }

}
