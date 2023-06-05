package com.example.goldshop.controller;

import com.example.goldshop.dto.RegisterRequest;
import com.example.goldshop.dto.UserRequestResponse;
import com.example.goldshop.entity.User;
import com.example.goldshop.manager.UserManager;
import com.example.goldshop.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserManager userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public UserRequestResponse getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveUser(@RequestBody @Valid UserRequestResponse user) {
        User user1 = userService.saveUser(user);
        System.out.println(user1);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void register(@RequestBody @Valid RegisterRequest request) {
        userService.register(request);
    }
}
