package com.kmbdata.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserOutListDto {
    private List<UserOutDto> users = new ArrayList<>();
}
