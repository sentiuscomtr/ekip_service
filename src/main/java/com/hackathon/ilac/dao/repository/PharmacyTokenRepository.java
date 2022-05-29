package com.hackathon.ilac.dao.repository;

import com.hackathon.ilac.model.entity.PharmacyToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PharmacyTokenRepository extends JpaRepository<PharmacyToken,String> {
    @Query("select t from PharmacyToken t where t.pharmacy.id= :id")
    Optional<PharmacyToken> findByPharmacyId(@Param("id")Long id);
}
