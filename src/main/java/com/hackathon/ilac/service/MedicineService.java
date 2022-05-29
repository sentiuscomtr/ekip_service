package com.hackathon.ilac.service;

import com.hackathon.ilac.dao.repository.MedicineRepository;
import com.hackathon.ilac.dao.repository.RecycleMedicineRepository;
import com.hackathon.ilac.model.dto.request.MedicineRequest;
import com.hackathon.ilac.model.dto.request.RecycleMedicineRequest;
import com.hackathon.ilac.model.dto.response.KomekMedicineResponse;
import com.hackathon.ilac.model.dto.response.MedicineResponse;
import com.hackathon.ilac.model.entity.Komek;
import com.hackathon.ilac.model.entity.Medicine;
import com.hackathon.ilac.model.entity.RecycleMedicine;
import com.hackathon.ilac.model.enums.RecycleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.naming.directory.SearchControls;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private RecycleMedicineRepository recycleMedicineRepository;
    @Autowired
    private KomekService komekService;

    public void  saveMedicine(@RequestBody MedicineRequest request){
            medicineRepository.findByNameAndSize(request.getName(),request.getSize()).ifPresentOrElse(medicine -> {
            },() -> {
                Medicine medicine=new Medicine();
                medicine.setName(request.getName());
                medicine.setSize(request.getSize());
                medicineRepository.save(medicine);
            });
    }

    public Page<MedicineResponse> searchMedicine(String keyword, Pageable pageable){
        return medicineRepository.findByNameLike(keyword,pageable).map(medicine -> {
            MedicineResponse  response=new MedicineResponse();
            response.setName(medicine.getName());
            response.setId(medicine.getId());
            response.setSize(medicine.getSize());
            return response;
        });
    }

    public void addRecycle(RecycleMedicineRequest request){
        var medicine=medicineRepository.findById(request.getMedicineId()).get();
        RecycleMedicine recycleMedicine=new RecycleMedicine();
        recycleMedicine.setMedicine(medicine);
        recycleMedicine.setNumber(request.getNumber());
        recycleMedicine.setType(request.getType());
        recycleMedicine.setSkt(request.getSkt());
        recycleMedicine.setKomek(Komek.builder().id(komekService.authId()).build());

        recycleMedicineRepository.save(recycleMedicine);
    }

    public List<KomekMedicineResponse> getKomekMer(Long merId){
        Set<Komek> komeks=recycleMedicineRepository.findByMedicineId(merId,RecycleType.CONSUME);
        if (komeks.size()==0){
            return null;
        }
        List<KomekMedicineResponse> responses=new ArrayList<>();
        komeks.forEach(komek -> {
            KomekMedicineResponse response=new KomekMedicineResponse();
            response.setKomekId(komek.getId());
            response.setLang(komek.getLang());
            response.setLat(komek.getLat());
            response.setKomekName(komek.getName());
            response.setNumber(0);
            List<RecycleMedicine> recycleMedicines=recycleMedicineRepository.countByKomekIdAndMericineId(komek.getId(), merId, RecycleType.CONSUME);
            recycleMedicines.forEach(recycleMedicine -> {
                int n=recycleMedicine.getNumber();
                response.setNumber(response.getNumber()+n);
            });

            responses.add(response);
        });
        return responses;
    }


}
