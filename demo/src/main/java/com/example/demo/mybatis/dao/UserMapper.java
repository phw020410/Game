package com.example.demo.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.mybatis.dto.User;

@Mapper
@Repository
public interface UserMapper {
    List<User> getAllUser();
}
