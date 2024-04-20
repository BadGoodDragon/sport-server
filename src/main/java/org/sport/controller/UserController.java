package org.sport.controller;

import lombok.RequiredArgsConstructor;
import org.sport.domain.User;
import org.sport.service.UserService;
import org.sport.util.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/register")
    @ResponseStatus(HttpStatus.OK)
    public void registration(@RequestHeader("Authorization") String authorization) {
        String username = Authorization.parseBasicUsername(authorization);
        String password = Authorization.parseBasicPassword(authorization);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setLatitude(0d);
        user.setLongtitude(0d);

        userService.add(user);

    }

    @PostMapping("/user/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestHeader("Authorization") String authorization) {
        String username = Authorization.parseBasicUsername(authorization);
        String password = Authorization.parseBasicPassword(authorization);

        User user = userService.getByName(username);

        if (user == null) {
            throw new RuntimeException("User not found!");
        }

        if (!password.equals(user.getPassword())) {
            throw new RuntimeException("Wrong password!");
        }

        String token = Authorization.generateToken(20);

        user.setToken(token);

        userService.updateToken(username, user);

        return token;
    }

}
