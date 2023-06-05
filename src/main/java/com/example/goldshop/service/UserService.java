package com.example.goldshop.service;
import com.example.goldshop.dto.RegisterRequest;
import com.example.goldshop.dto.UserRequestResponse;
import com.example.goldshop.entity.User;

public interface UserService {

    UserRequestResponse getById(int id);
    User saveUser(UserRequestResponse user);

    void deleteUser(int id);

    User getUserByEmail(String email);

    void register(RegisterRequest request);
}
