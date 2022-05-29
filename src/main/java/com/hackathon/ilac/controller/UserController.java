package com.hackathon.ilac.controller;

import com.hackathon.ilac.auth.details.UserAuthDetails;
import com.hackathon.ilac.model.dto.request.UserMessageRequest;
import com.hackathon.ilac.service.ChatService;
import com.hackathon.ilac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<?>  getUser(){
        return ResponseEntity.ok(userService.getAuth());
    }

    @PostMapping("/chat")
    public ResponseEntity<?> sendMessage(@Valid @RequestBody UserMessageRequest request){
        chatService.sendUserMessage(request);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/chat")
    public ResponseEntity<?> getChats(Pageable pageable){
        return ResponseEntity.ok(chatService.getUserChats(pageable));
    }
    @GetMapping("/chat/message/{id}")
    public ResponseEntity<?> getChatMessage(@PathVariable("id")Long id,Pageable pageable){
        return ResponseEntity.ok(chatService.getMessageByChatId(id,pageable));
    }


}
