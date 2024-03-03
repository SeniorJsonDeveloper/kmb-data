package com.kmbdata.controller;

import com.kmbdata.dto.UserCreateDto;
import com.kmbdata.dto.UserOutDto;
import com.kmbdata.mapper.UserMapper;
import com.kmbdata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;



    @GetMapping("/{id}")
    public UserOutDto getUserById(@PathVariable Integer id){
        return userMapper.toUserOutDto(userService.getById(id));
    }
    @PostMapping("/create")
    public UserOutDto createUser(@RequestBody UserCreateDto userCreateDto){
        return userService.createUser(userCreateDto);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
