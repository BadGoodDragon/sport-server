package org.sport.controller;

import org.sport.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserController {

    private UserService userService;

    @PostMapping("/user/register")
    @ResponseStatus(HttpStatus.OK)
    void registration(@RequestHeader("Authorization") String authorization) {

    }

    @PostMapping("/user/login")
    @ResponseStatus(HttpStatus.OK)
    void login(@RequestHeader("Authorization") String authorization) {

    }

    @PostMapping("/user/update")
    @ResponseStatus(HttpStatus.OK)
    void update(@RequestHeader("Authorization") String authorization) {}


}
