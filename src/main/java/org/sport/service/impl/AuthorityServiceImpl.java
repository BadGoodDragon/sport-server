package org.sport.service.impl;


import lombok.RequiredArgsConstructor;
import org.sport.domain.Authority;
import org.sport.repository.AuthorityRepository;
import org.sport.service.AuthorityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    @Override
    public Authority add(Authority authority) {

        Optional<Authority> optionalAuthority = authorityRepository.findByAuthority(authority.getAuthority());

        //return optionalAuthority.orElseGet(() -> authorityRepository.save(authority));

        if (optionalAuthority.isPresent()) return optionalAuthority.get();
        else return authorityRepository.save(authority);
    }

    @Override
    public List<Authority> getAll() {
        return authorityRepository.findAll();
    }
}