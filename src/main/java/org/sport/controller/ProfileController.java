package org.sport.controller;

import lombok.RequiredArgsConstructor;
import org.sport.dto.AllOutProfile;
import org.sport.service.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/profile/{username}")
    public AllOutProfile getProfileTest(@PathVariable String username) {
        return profileService.getAllOutProfile(username);
    }

    @GetMapping("/profile/add_friend/{owner}/{slave}")
    public void addFriendTest(@PathVariable String owner, @PathVariable String slave) {
        profileService.addFriend(owner, slave);
    }

    @GetMapping("/profile/addfriend")
    public void addFriend(@RequestBody() String slave) {
        profileService.addFriend("TODO : get name from autorization", slave);
    }
}
