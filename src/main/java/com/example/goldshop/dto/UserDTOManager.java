package com.example.goldshop.dto;

import com.example.goldshop.entity.User;

import java.util.function.Function;

public class UserDTOManager implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {return new UserDTO(user.getEmail(),user.getPassword());
    }
}
