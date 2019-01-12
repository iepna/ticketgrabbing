package com.tp.springbootjpa.dao;

import com.tp.springbootjpa.pojo.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    /**
     * 减少库存
     */
    @Transactional
    @Modifying
    @Query(value = "update ticket set t.count=t.count+(-1) where id=?!",nativeQuery = true)
    int reduceCount(Integer id);
    /**
     * 查询信息
     */
    Ticket findTicketById(Integer id);
}
