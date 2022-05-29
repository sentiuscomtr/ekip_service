package com.hackathon.ilac.service;

import com.hackathon.ilac.auth.details.KomekAuthDetails;
import com.hackathon.ilac.auth.details.PharmacyAuthDetails;
import com.hackathon.ilac.dao.repository.KomekRepository;
import com.hackathon.ilac.model.dto.response.KomekResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KomekService {
    @Autowired
    private KomekRepository komekRepository;

   public List<KomekResponse> getKomeks(){
       return komekRepository.findAll().stream().map(komek -> {
           KomekResponse response=new KomekResponse();
           response.setCity(komek.getCity());
           response.setId(komek.getId());
           response.setLang(komek.getLang());
           response.setLat(komek.getLat());
           response.setName(komek.getName());
           return response;
       }).collect(Collectors.toList());
    }

    public Long authId(){
        KomekAuthDetails pharmacyAuthDetails=(KomekAuthDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return pharmacyAuthDetails.getKomek().getId();
    }
}
