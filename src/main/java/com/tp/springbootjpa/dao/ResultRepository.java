package com.tp.springbootjpa.dao;

import com.tp.springbootjpa.pojo.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ResultRepository extends JpaRepository<Result,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into result(ticket_id,user_id) values(?1,?2)",nativeQuery = true)
    void add(@Param("ticketId") Integer ticketId,@Param("userId") Integer userId);

    Result findByUserId(Integer userId);
}
