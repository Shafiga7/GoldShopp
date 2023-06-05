package com.example.goldshop.mapper;

import com.example.goldshop.dto.RegisterRequest;
import com.example.goldshop.dto.UserRequestResponse;
import com.example.goldshop.entity.User;
import com.example.goldshop.security.MyUserDetails;
import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserRequestResponse toUserDTO(User user);

    User toEntity(UserRequestResponse userRequestResponse);


    User toUserFromRegisterRequest(RegisterRequest request);

    MyUserDetails toMyUserDetails(User user);
}
