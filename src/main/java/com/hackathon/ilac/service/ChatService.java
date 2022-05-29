package com.hackathon.ilac.service;

import com.hackathon.ilac.dao.repository.ChatMessageRepository;
import com.hackathon.ilac.dao.repository.ChatRepository;
import com.hackathon.ilac.model.dto.request.PharmacyMessageRequest;
import com.hackathon.ilac.model.dto.request.UserMessageRequest;
import com.hackathon.ilac.model.dto.response.ChatMessageResponse;
import com.hackathon.ilac.model.dto.response.ChatResponse;
import com.hackathon.ilac.model.entity.Chat;
import com.hackathon.ilac.model.entity.ChatMessage;
import com.hackathon.ilac.model.entity.Pharmacy;
import com.hackathon.ilac.model.entity.User;
import com.hackathon.ilac.model.enums.Sender;
import com.hackathon.ilac.model.message.SockMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PharmacyService pharmacyService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public void sendUserMessage(UserMessageRequest request){
        chatRepository.findByUserIdAndPharmacyId(request.getPharmacyId(),userService.authId()).ifPresentOrElse(chat -> {
            ChatMessage chatMessage=new ChatMessage();
            chatMessage.setChat(chat);
            chatMessage.setMessage(request.getMessage());
            chatMessage.setSender(Sender.USER);
            chatMessage.setDate(LocalDateTime.now());
            chatMessageRepository.save(chatMessage);
            SockMessage message=new SockMessage();
            message.setMessage(request.getMessage());
            message.setDate(chatMessage.getDate());
            messagingTemplate.convertAndSend("/chat/"+chat.getId(),message);
        },() -> {
            Chat chat=new Chat();
            chat.setUser(User.builder().id(userService.authId()).build());
            chat.setPharmacy(Pharmacy.builder().id(request.getPharmacyId()).build());
            chat=chatRepository.save(chat);
            ChatMessage chatMessage=new ChatMessage();
            chatMessage.setMessage(request.getMessage());
            chatMessage.setChat(chat);
            chatMessage.setDate(LocalDateTime.now());
            chatMessage.setSender(Sender.USER);
            chatMessageRepository.save(chatMessage);
            SockMessage message=new SockMessage();
            message.setMessage(request.getMessage());
            message.setDate(chatMessage.getDate());
            messagingTemplate.convertAndSend("/chat/"+chat.getId(),message);
        });
    }
    public void sendPharmacyMessage(PharmacyMessageRequest request){
        chatRepository.findByUserIdAndPharmacyId(pharmacyService.getAuthId(),request.getUserId()).ifPresentOrElse(chat -> {
            ChatMessage chatMessage=new ChatMessage();
            chatMessage.setChat(chat);
            chatMessage.setMessage(request.getMessage());
            chatMessage.setSender(Sender.PHARMACY);
            chatMessage.setDate(LocalDateTime.now());
            chatMessageRepository.save(chatMessage);
            SockMessage message=new SockMessage();
            message.setMessage(request.getMessage());
            message.setDate(chatMessage.getDate());
            messagingTemplate.convertAndSend("/chat/"+chat.getId(),message);
        },() -> {
            Chat chat=new Chat();
            chat.setUser(User.builder().id(request.getUserId()).build());
            chat.setPharmacy(Pharmacy.builder().id(pharmacyService.getAuthId()).build());
            chat=chatRepository.save(chat);
            ChatMessage chatMessage=new ChatMessage();
            chatMessage.setMessage(request.getMessage());
            chatMessage.setChat(chat);
            chatMessage.setDate(LocalDateTime.now());
            chatMessage.setSender(Sender.PHARMACY);
            chatMessageRepository.save(chatMessage);
            SockMessage message=new SockMessage();
            message.setMessage(request.getMessage());
            message.setDate(chatMessage.getDate());
            messagingTemplate.convertAndSend("/chat/"+chat.getId(),message);
        });
    }

    public Page<ChatResponse> getPharmacyChats(Pageable pageable){
       return chatRepository.findByPharmacyId(pharmacyService.getAuthId(),pageable).map(chat -> {
          ChatResponse response=new ChatResponse();
          response.setId(chat.getId());
          response.setUserId(chat.getUser().getId());
          response.setPharmacyName(chat.getPharmacy().getName());
          return response;
       });
    }

    public Page<ChatResponse> getUserChats(Pageable pageable){
        return chatRepository.findByUserId(userService.authId(),pageable).map(chat -> {
            ChatResponse response=new ChatResponse();
            response.setId(chat.getId());
            response.setUserId(chat.getUser().getId());
            response.setPharmacyName(chat.getPharmacy().getName());
            return response;
        });
    }

    public Page<ChatMessageResponse> getMessageByChatId(Long id,Pageable pageable){
        return chatMessageRepository.findByChatId(id,pageable).map(chatMessage -> {
            ChatMessageResponse response=new ChatMessageResponse();
            response.setMessage(chatMessage.getMessage());
            response.setDate(chatMessage.getDate());
            response.setSender(chatMessage.getSender());
            return response;
        });
    }
}
