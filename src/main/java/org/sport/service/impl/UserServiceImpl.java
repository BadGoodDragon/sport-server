package org.sport.service.impl;

import lombok.RequiredArgsConstructor;
import org.sport.domain.User;
import org.sport.repository.FriendRelationRepository;
import org.sport.repository.UserRepository;
import org.sport.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User update(String username, User user) {
        User lastUser = userRepository.findByUsername(username);
        if (lastUser == null) {
            throw new RuntimeException("User with NAME " + username + " not found");
        }

        lastUser.setPhoto(user.getPhoto());
        lastUser.setLatitude(user.getLatitude());
        lastUser.setLongtitude(user.getLongtitude());
        lastUser.setPassword(user.getPassword());

        return userRepository.save(user);
    }

    @Override
    public void deleteByName(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public User getNameByToken(String token) {
        return userRepository.findByToken(token);
    }
}
