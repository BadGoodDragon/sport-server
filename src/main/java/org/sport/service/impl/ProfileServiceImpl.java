package org.sport.service.impl;

import lombok.RequiredArgsConstructor;
import org.sport.domain.FriendRelation;
import org.sport.domain.User;
import org.sport.dto.AllOutProfile;
import org.sport.dto.FriendOutProfile;
import org.sport.dto.UserOutProfile;
import org.sport.repository.FriendRelationRepository;
import org.sport.repository.UserRepository;
import org.sport.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final UserRepository userRepository;
    private final FriendRelationRepository friendRelationRepository;

    @Override
    public List<FriendOutProfile> getFriendList(String username) {
        List<FriendOutProfile> result = new ArrayList<>();

        List<FriendRelation> midlData = friendRelationRepository.findAllByOwner(username);

        for (FriendRelation midl : midlData) {
            User u = userRepository.findByUsername(midl.getSlave());
            result.add(new FriendOutProfile(u.getUsername(), u.getPhoto()));
        }

        return result;
    }

    @Override
    public UserOutProfile getUser(String username) {
        UserOutProfile userDto = new UserOutProfile();

        User user = userRepository.findByUsername(username);

        userDto.setUsername(user.getUsername());
        userDto.setPhoto(user.getPhoto());

        return userDto;
    }

    @Override
    public AllOutProfile getAllOutProfile(String username) {
        AllOutProfile userDto = new AllOutProfile();

        List<FriendOutProfile> friendList = getFriendList(username);

        UserOutProfile userProfile = getUser(username);

        userDto.setUsername(userProfile.getUsername());
        userDto.setPhoto(userProfile.getPhoto());
        userDto.setFriendList(friendList);


        return userDto;
    }

    @Override
    public void addFriend(String owner, String slave) {
        FriendRelation forward = new FriendRelation();
        forward.setOwner(owner);
        forward.setSlave(slave);

        FriendRelation backward = new FriendRelation();
        backward.setOwner(slave);
        backward.setSlave(owner);

        friendRelationRepository.save(forward);
        friendRelationRepository.save(backward);
    }
}
