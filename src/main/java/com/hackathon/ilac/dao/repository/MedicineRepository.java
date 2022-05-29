package com.hackathon.ilac.dao.repository;

import com.hackathon.ilac.model.entity.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MedicineRepository extends JpaRepository<Medicine,Long>{
    @Query("select m from Medicine  m where m.name= :name and m.size= :size")
    Optional<Medicine> findByNameAndSize(@Param("name")String name,@Param("size")int size);

    @Query("select m from Medicine  m where lower(m.name) like lower(concat('%',?1,'%') )")
    Page<Medicine> findByNameLike(String keyword, Pageable pageable);
}
