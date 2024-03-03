package com.kmbdata.service.impl;

import com.kmbdata.dto.UserCreateDto;
import com.kmbdata.dto.UserOutDto;
import com.kmbdata.entity.UserEntity;
import com.kmbdata.exception.BadRequestException;
import com.kmbdata.exception.NotFoundException;
import com.kmbdata.repository.UserRepository;
import com.kmbdata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getById(Integer id) {
        return userRepository.findById(id).orElseThrow(
                ()->new NotFoundException(MessageFormat.format("User with id: {0} not found",id)));
    }

    @Override
    public UserOutDto createUser(UserCreateDto userCreateDto) {
        UserEntity user = new UserEntity();
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(userCreateDto.getPassword());
        if(userRepository.existsByUsername(userCreateDto.getUsername())){
            throw new BadRequestException("User with this username already exist!");
        }
        userRepository.save(user);
        UserOutDto userOutDto = new UserOutDto();
        userOutDto.setId(user.getId());
        userOutDto.setUsername(user.getUsername());
        userOutDto.setCreatedAt(LocalDateTime.now());
        return userOutDto;
    }

    @Override
    public void deleteUser(Integer id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(()->new NotFoundException(
                        (MessageFormat.format("User with id: {0} not found",id))
                ));
        userRepository.deleteById(id);
    }
}
