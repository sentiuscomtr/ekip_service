package com.hackathon.ilac.dao.repository;

import com.hackathon.ilac.model.entity.User;
import com.hackathon.ilac.model.entity.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserTokenRepository extends JpaRepository<UserToken,String> {
    @Query("select t from UserToken t where t.user.id= :id")
    Optional<UserToken> findByUserId(@Param("id")Long id);
}
