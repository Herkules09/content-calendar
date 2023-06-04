package com.herkules09.contentcalendar.repository;

import com.herkules09.contentcalendar.model.Content;

import com.herkules09.contentcalendar.model.Status;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content,Integer> {

    List<Content> findAllByTitleContains(String keyword);


    @Query(" select c from Content c where c.status = :status ")
    List<Content>listByStatus(@Param("status") Status status);

}
