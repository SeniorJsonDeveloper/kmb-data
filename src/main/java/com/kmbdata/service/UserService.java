package com.kmbdata.service;

import com.kmbdata.dto.UserCreateDto;
import com.kmbdata.dto.UserOutDto;
import com.kmbdata.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAll();
    UserEntity getById(Integer id);
    UserOutDto createUser(UserCreateDto userCreateDto);
    void deleteUser(Integer id);
}
