package com.hackathon.ilac.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/api/auth/user/login")
    ResponseEntity<?> userLogin(@Valid @RequestBody Credentials credentials){
        return ResponseEntity.ok(authService.userLogin(credentials));
    }

    @PostMapping("/api/auth/pharmacy/login")
    ResponseEntity<?> userPhar(@Valid @RequestBody Credentials credentials){
        return ResponseEntity.ok(authService.pharmacyLogin(credentials));
    }
    @PostMapping("/api/auth/kbb/login")
    ResponseEntity<?> userKBB(@Valid @RequestBody Credentials credentials){
        return ResponseEntity.ok(authService.kbbLogi(credentials));
    }
}
