package com.hackathon.ilac.scheduled;

import com.hackathon.ilac.dao.repository.PharmacyRepository;
import com.hackathon.ilac.dao.rest.rest.DutyPharmacyDAO;
import com.hackathon.ilac.model.entity.Pharmacy;
import com.hackathon.ilac.model.jsonElement.DutyPharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Timer;

@EnableAsync
@Service
public class DutyPharmacyScheduled {
    @Autowired
    private DutyPharmacyDAO dutyPharmacyDAO;
    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Scheduled(fixedDelay = 50000000)
    @Async
    public void checkDuty(){
        var dutyPhar=dutyPharmacyDAO.getDutyPharmacy();
        pharmacyRepository.resetDutyPharmacy();
        dutyPhar.getResult().forEach(dutyPharmacy -> {
            pharmacyRepository.findByName(dutyPharmacy.getName()+" ECZANESİ").ifPresent(pharmacy -> {
                pharmacy.forEach(pharmacy1 ->pharmacy1.setDutyPharmacy(true));
                try {
                    Thread.sleep(500);
                }catch (Exception e){

                }
                pharmacyRepository.saveAll(pharmacy);
            });
        });
    }
}
