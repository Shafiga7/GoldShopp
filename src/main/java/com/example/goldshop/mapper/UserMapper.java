package com.example.goldshop.mapper;

import com.example.goldshop.dto.RegisterRequest;
import com.example.goldshop.dto.UserRequestResponse;
import com.example.goldshop.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserRequestResponse toUserDTO(User user);

    User toEntity(UserRequestResponse userRequestResponse);

//    MyUserDetails toMyUserDetails(User user);

    User toUserFromRegisterRequest(RegisterRequest request);
}
