package com.hackathon.ilac.service;

import com.hackathon.ilac.auth.details.UserAuthDetails;
import com.hackathon.ilac.model.dto.request.UserLoginRequest;
import com.hackathon.ilac.model.dto.response.UserResponse;
import com.hackathon.ilac.model.entity.User;
import com.hackathon.ilac.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SmsService smsService;

    public  void login(UserLoginRequest request){
        userRepository.findByPhone(request.getPhone()).ifPresentOrElse(user -> {
            String pass=createPassword();
            user.setPassword(pass);
            userRepository.save(user);
            smsService.sendPassword(request.getPhone(),pass);
        },() -> {
            User user=new User();
            user.setPhone(request.getPhone());
            String pass=createPassword();
            user.setPassword(pass);
            userRepository.save(user);
            smsService.sendPassword(request.getPhone(),pass);
        });
    }

    public Long authId(){
        UserAuthDetails userDetails=(UserAuthDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return userDetails.getUser().getId();
    }

    public UserResponse getAuth(){
        UserAuthDetails userDetails=(UserAuthDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        UserResponse response=new UserResponse();
        response.setId(userDetails.getUser().getId());
        response.setPhone(userDetails.getUser().getPhone());
        return response;
    }

    private String createPassword(){
        var check=true;
        String code="";
        do {
            Random random=new Random();
            code=String.valueOf(random.nextInt(999999));
            if (code.length()==6){
                check=false;
            }

        }while (check);
        return code;
    }

}
