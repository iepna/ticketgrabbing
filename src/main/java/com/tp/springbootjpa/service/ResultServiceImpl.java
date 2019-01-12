package com.tp.springbootjpa.service;

import com.tp.springbootjpa.dao.ResultRepository;
import com.tp.springbootjpa.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultRepository resultRepository;
    public void add(Result result) {
        resultRepository.add(result.getTicketId(),result.getUserId());
    }

    public Result findOneByUserId(Integer userId) {
        return resultRepository.findByUserId(userId);
    }
}
