package com.kmbdata.mapper;

import com.kmbdata.dto.UserCreateDto;
import com.kmbdata.dto.UserOutDto;
import com.kmbdata.dto.UserOutListDto;
import com.kmbdata.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "username",source = "username")
    @Mapping(target = "password",source = "password")
    @Mapping(target = "createdAt",ignore = true)
    UserEntity toEntity(UserCreateDto userCreateDto);
    List<UserOutDto> toList(List<UserEntity> users);
    @Mapping(target = "username",source = "username")
    @Mapping(target = "createdAt",source = "createdAt")
    UserOutDto toUserOutDto(UserEntity user);
}
