package org.sport.service;

import org.sport.domain.Authority;

import java.util.List;

public interface AuthorityService {
    Authority add(Authority authority);

    List<Authority> getAll();
}