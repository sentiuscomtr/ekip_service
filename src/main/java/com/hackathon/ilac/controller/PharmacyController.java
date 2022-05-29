package com.hackathon.ilac.controller;

import com.hackathon.ilac.model.dto.request.PharmacyMessageRequest;
import com.hackathon.ilac.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/pharmacy")
public class PharmacyController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/chat")
    public ResponseEntity<?> sendMessage(@Valid @RequestBody PharmacyMessageRequest request){
        chatService.sendPharmacyMessage(request);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/chat")
    public ResponseEntity<?> getChats(Pageable pageable){
        return ResponseEntity.ok(chatService.getPharmacyChats(pageable));
    }

    @GetMapping("/chat/message/{id}")
    public ResponseEntity<?> getChatMessage(@PathVariable("id")Long id,Pageable pageable){
        return ResponseEntity.ok(chatService.getMessageByChatId(id,pageable));
    }
}
