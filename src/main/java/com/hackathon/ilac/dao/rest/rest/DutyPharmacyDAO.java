package com.hackathon.ilac.dao.rest.rest;

import com.hackathon.ilac.model.jsonElement.DutyPharmacyJson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class DutyPharmacyDAO {

    public DutyPharmacyJson getDutyPharmacy(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", "apikey 0fiYTalAWgYj1cMT2HevSj:16d37J5avm2PRpZ1ugkDDA");
        headers.add("content-type","application/json");
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<DutyPharmacyJson> response = new RestTemplate().exchange("https://api.collectapi.com/health/dutyPharmacy?il=Konya",
                HttpMethod.GET,
                request,
                DutyPharmacyJson.class);
        return response.getBody();
    }
}
