package org.sport.service;

import org.sport.dto.AllOutProfile;
import org.sport.dto.FriendOutProfile;
import org.sport.dto.UserOutProfile;

import java.util.List;

public interface ProfileService {
    List<FriendOutProfile> getFriendList(String username);
    UserOutProfile getUser(String username);
    AllOutProfile getAllOutProfile(String username);
    void addFriend(String owner, String slave);
}
