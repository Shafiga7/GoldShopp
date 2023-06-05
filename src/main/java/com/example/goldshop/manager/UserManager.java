package com.example.goldshop.manager;

import com.example.goldshop.dto.RegisterRequest;
import com.example.goldshop.dto.UserRequestResponse;
import com.example.goldshop.entity.User;
import com.example.goldshop.exception.UserNotFoundException;
import com.example.goldshop.mapper.UserMapper;
import com.example.goldshop.repository.UserRepository;
import com.example.goldshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper ;

    private final PasswordEncoder encoder;


    @Override
    public UserRequestResponse getById(int id) {
        return userRepository.findById(id)
                .stream()
                .map(userMapper::toUserDTO)
                .findFirst()
                .orElseThrow(()->new UserNotFoundException("User tapilmadi"));
    }

    @Override
    public User saveUser(UserRequestResponse userDTO)  {
        return userRepository.save(userMapper.toEntity(userDTO));
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.
                findUserByEmail(email).
                orElseThrow(()->new UserNotFoundException("User tapilmadi"));
    }

    @Override
    public void register(RegisterRequest request) {
        User user = userMapper.toUserFromRegisterRequest(request);
        user.setPassword(encoder.encode(request.password()));
        userRepository.save(user);
    }
}
