package org.sport.controller;

import lombok.RequiredArgsConstructor;
import org.sport.domain.User;
import org.sport.dto.AllOutProfile;
import org.sport.service.ProfileService;
import org.sport.service.UserService;
import org.sport.util.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;
    private final UserService userService;

    @GetMapping("/profile/{username}")
    public AllOutProfile getProfileTest(@PathVariable String username) {
        return profileService.getAllOutProfile(username);
    }

    @GetMapping("/profile")
    public AllOutProfile getProfile(@RequestHeader("Authorization") String bearerToken) {
        User user = userService.getByToken(Authorization.parseBearer(bearerToken));
        // Тут возможно нулл поинтер ексепшон
        return profileService.getAllOutProfile(user.getUsername());
    }

    @GetMapping("/profile/add_friend/{owner}/{slave}")
    @ResponseStatus(HttpStatus.OK)
    public void addFriendTest(@PathVariable String owner, @PathVariable String slave) {
        profileService.addFriend(owner, slave);
    }

    @PostMapping("/profile/add_friend")
    @ResponseStatus(HttpStatus.OK)
    public void addFriend(@RequestHeader("Authorization") String bearerToken, @RequestParam(name="slave") String slave) {
        User user = userService.getByToken(Authorization.parseBearer(bearerToken));
        // null pointer
        profileService.addFriend(user.getUsername(), slave);
    }

    @PostMapping("/profile/update_coords")
    @ResponseStatus(HttpStatus.OK)
    public void updateCoords(@RequestHeader("Authorization") String bearerToken, @RequestBody User user) {
        User userDb = userService.getByToken(Authorization.parseBearer(bearerToken));
        userService.updateCoords(userDb.getUsername(), user);
    }

    @PostMapping("/profile/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestHeader("Authorization") String bearerToken, @RequestBody User user) {
        User userDb = userService.getByToken(Authorization.parseBearer(bearerToken));
        userService.update(userDb.getUsername(), user);
    }
}
