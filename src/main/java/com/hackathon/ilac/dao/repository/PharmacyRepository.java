package com.hackathon.ilac.dao.repository;

import com.hackathon.ilac.model.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PharmacyRepository extends JpaRepository<Pharmacy,Long>{
    @Query("select p from Pharmacy p where p.name= :name")
     Optional<List<Pharmacy>> findByName(@Param("name")String name);

    @Modifying
    @Transactional
    @Query("UPDATE Pharmacy  p set p.dutyPharmacy= false")
    void resetDutyPharmacy();

    @Query("select p from Pharmacy p where p.dutyPharmacy= true ")
    List<Pharmacy> findDutyPharmacy();
}
