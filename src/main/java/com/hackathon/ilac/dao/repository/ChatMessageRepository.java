package com.hackathon.ilac.dao.repository;

import com.hackathon.ilac.model.entity.ChatMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChatMessageRepository extends JpaRepository<ChatMessage,Long>{
    @Query("select cm from ChatMessage cm where cm.chat.id= :id")
    Page<ChatMessage> findByChatId(@Param("id")Long id, Pageable pageable);
}
