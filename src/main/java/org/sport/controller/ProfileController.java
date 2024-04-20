package org.sport.controller;

import lombok.RequiredArgsConstructor;
import org.sport.dto.AllOutProfile;
import org.sport.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/profile/{username}")
    public AllOutProfile getProfileTest(@PathVariable String username) {
        return profileService.getAllOutProfile(username);
    }

    @GetMapping("/profile/{username}")
    public AllOutProfile getProfile(@RequestHeader("Authorization") String authorization) {
        return profileService.getAllOutProfile(authorization);
    }

    @GetMapping("/profile/add_friend/{owner}/{slave}")
    @ResponseStatus(HttpStatus.OK)
    public void addFriendTest(@PathVariable String owner, @PathVariable String slave) {
        profileService.addFriend(owner, slave);
    }

    @PostMapping("/profile/add_friend")
    @ResponseStatus(HttpStatus.OK)
    public void addFriend(@RequestHeader("Authorization") String authorization, @RequestBody() String slave) {
        //profileService.addFriend("TODO : get name from autorization", slave);
    }
}
