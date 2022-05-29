package com.hackathon.ilac.dao.repository;

import com.hackathon.ilac.model.entity.Komek;
import com.hackathon.ilac.model.entity.Medicine;
import com.hackathon.ilac.model.entity.RecycleMedicine;
import com.hackathon.ilac.model.enums.RecycleType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface RecycleMedicineRepository extends JpaRepository<RecycleMedicine,Long> {

    @Query("select m from RecycleMedicine  m where lower(m.medicine.name) like lower(concat('%',?1,'%') )")
    Page<RecycleMedicine> findByNameLike(String keyword, Pageable pageable);

    @Query("select m.komek AS id from RecycleMedicine m where m.medicine.id= :id and m.type= :type")
    Set<Komek> findByMedicineId(@Param("id")Long id, @Param("type")RecycleType type);

    @Query("select r from RecycleMedicine r where r.komek.id= :komekId and r.medicine.id= :merId and r.type= :type")
    List<RecycleMedicine> countByKomekIdAndMericineId(@Param("komekId")Long komekId, @Param("merId")Long merId, @Param("type")RecycleType type);

}
