package com.hackathon.ilac.dao.repository;

import com.hackathon.ilac.model.entity.Chat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat,Long>{
    @Query("select c from Chat c where c.pharmacy.id= :pharId and c.user.id= :userID")
    Optional<Chat> findByUserIdAndPharmacyId(@Param("pharId")Long pharId,@Param("userID")Long userId);

    @Query("select c from Chat c where c.pharmacy.id= :id")
    Page<Chat> findByPharmacyId(@Param("id")Long id, Pageable pageable);
    @Query("select c from Chat c where c.user.id= :id")
    Page<Chat> findByUserId(@Param("id")Long id, Pageable pageable);
}
