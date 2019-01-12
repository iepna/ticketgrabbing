package com.tp.springbootjpa.service;


import com.tp.springbootjpa.pojo.Result;

public interface ResultService {
    void add(Result result);
    Result findOneByUserId(Integer userId);
}
