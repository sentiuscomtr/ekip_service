package com.hackathon.ilac.dao.repository;

import com.hackathon.ilac.model.entity.Komek;
import com.hackathon.ilac.model.entity.KomekToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface KomekRepository extends JpaRepository<Komek,Long> {
    @Query("select kt from KomekToken kt where kt.komek.id= :id")
    Optional<KomekToken> findByKomekId(@Param("id")Long id);
}
