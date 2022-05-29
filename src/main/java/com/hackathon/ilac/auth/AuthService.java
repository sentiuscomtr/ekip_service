package com.hackathon.ilac.auth;

import com.hackathon.ilac.auth.details.KomekAuthDetails;
import com.hackathon.ilac.auth.details.PharmacyAuthDetails;
import com.hackathon.ilac.auth.details.UserAuthDetails;
import com.hackathon.ilac.dao.repository.*;
import com.hackathon.ilac.error.CustomError;
import com.hackathon.ilac.error.ErrorConstans;
import com.hackathon.ilac.model.entity.KomekToken;
import com.hackathon.ilac.model.entity.PharmacyToken;
import com.hackathon.ilac.model.entity.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AuthService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Autowired
    private PharmacyTokenRepository pharmacyTokenRepository;
    @Autowired
    private UserTokenRepository userTokenRepository;

    @Autowired
    private KomekRepository komekRepository;

    @Autowired
    private KomekTokenRepository komekTokenRepository;

    @Transactional
    public TokenResponse userLogin(Credentials credentials) {
        var user=userRepository.findByPhone(credentials.getUsername()).orElseThrow(() -> new CustomError(ErrorConstans.LOGIN));
        if (!user.getPassword().equals(credentials.getPassword())){
            throw new CustomError(ErrorConstans.LOGIN);
        }
        UserToken userToken=new UserToken();
        userToken.setUser(user);
        userToken.setToken(UUID.randomUUID().toString());
        userTokenRepository.findByUserId(user.getId()).ifPresent(token -> {
            userTokenRepository.delete(token);
        });
        userTokenRepository.save(userToken);
        TokenResponse response=new TokenResponse();
        response.setToken(userToken.getToken());
        return response;

    }

    @Transactional
    public TokenResponse pharmacyLogin(Credentials credentials){

        var phar=pharmacyRepository.findById(Long.parseLong(credentials.getUsername())).orElseThrow(() -> new CustomError(ErrorConstans.LOGIN));
        if (!phar.getPassword().equals(credentials.getPassword())){
            throw new CustomError(ErrorConstans.LOGIN);
        }
        pharmacyTokenRepository.findByPharmacyId(phar.getId()).ifPresent(token -> {
            pharmacyTokenRepository.delete(token);
        });
        PharmacyToken pharmacyToken=new PharmacyToken();
        pharmacyToken.setPharmacy(phar);
        pharmacyToken.setToken(UUID.randomUUID().toString());
        TokenResponse  response=new TokenResponse();
        response.setToken(pharmacyToken.getToken());
        return response;
    }
    public TokenResponse kbbLogi(Credentials credentials){
        var komek=komekRepository.findById(Long.parseLong(credentials.getUsername())).orElseThrow(() -> new CustomError(ErrorConstans.LOGIN));
        if (!komek.getPassword().equals(credentials.getPassword())){
            throw new CustomError(ErrorConstans.LOGIN);
        }
        komekRepository.findByKomekId(komek.getId()).ifPresent(komekToken -> {
            komekTokenRepository.delete(komekToken);
        });
        KomekToken komekToken=new KomekToken();
        komekToken.setKomek(komek);
        komekToken.setToken(UUID.randomUUID().toString());
        komekTokenRepository.save(komekToken);
        TokenResponse  response=new TokenResponse();
        response.setToken(komekToken.getToken());
        return response;
    }

    @Transactional
    public UserDetails getUser(String token){
        var ut=userTokenRepository.findById(token).orElseThrow(() -> new CustomError(ErrorConstans.LOGIN));
        UserAuthDetails authDetails=new UserAuthDetails();
        authDetails.setUser(ut.getUser());
        return authDetails;
    }

    @Transactional
    public UserDetails getPharmacy(String token){
        var pt=pharmacyTokenRepository.findById(token).orElseThrow(() -> new CustomError(ErrorConstans.LOGIN));
        PharmacyAuthDetails pharmacyAuthDetails=new PharmacyAuthDetails();
        pharmacyAuthDetails.setPharmacy(pt.getPharmacy());
        return pharmacyAuthDetails;
    }

    @Transactional
    public UserDetails getKomek(String token){
        var kt=komekTokenRepository.findById(token).orElseThrow(() -> new CustomError(ErrorConstans.LOGIN));
        KomekAuthDetails komekAuthDetails=new KomekAuthDetails();
        komekAuthDetails.setKomek(kt.getKomek());
        return komekAuthDetails;
    }



}
