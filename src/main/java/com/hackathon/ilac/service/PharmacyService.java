package com.hackathon.ilac.service;

import com.hackathon.ilac.auth.details.PharmacyAuthDetails;
import com.hackathon.ilac.auth.details.UserAuthDetails;
import com.hackathon.ilac.dao.repository.PharmacyRepository;
import com.hackathon.ilac.model.dto.response.PharmacyResponse;
import com.hackathon.ilac.model.entity.Pharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PharmacyService {
    @Autowired
    private PharmacyRepository pharmacyRepository;

    public List<PharmacyResponse> getAllPharmacy(){
        List<Pharmacy> pharmacies=pharmacyRepository.findAll();
        List<PharmacyResponse> responses=new ArrayList<>();
        pharmacies.forEach(pharmacy -> {
            PharmacyResponse response=new PharmacyResponse();
            response.setId(pharmacy.getId());
            response.setLat(pharmacy.getLat());
            response.setLang(pharmacy.getLang());
            response.setName(pharmacy.getName());
            responses.add(response);
        });
        return responses;
    }

    public List<PharmacyResponse> getDutyPharmacy(){
        List<Pharmacy> pharmacies=pharmacyRepository.findDutyPharmacy();
        List<PharmacyResponse> responses=new ArrayList<>();
        pharmacies.forEach(pharmacy -> {
            PharmacyResponse response=new PharmacyResponse();
            response.setId(pharmacy.getId());
            response.setLat(pharmacy.getLat());
            response.setLang(pharmacy.getLang());
            response.setName(pharmacy.getName());
            responses.add(response);
        });
        return responses;
    }

    public Long getAuthId(){
        PharmacyAuthDetails pharmacyAuthDetails=(PharmacyAuthDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        return pharmacyAuthDetails.getPharmacy().getId();
    }

}
