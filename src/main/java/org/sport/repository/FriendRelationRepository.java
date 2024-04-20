package org.sport.repository;

import org.sport.domain.FriendRelation;
import org.sport.dto.FriendOutProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRelationRepository extends JpaRepository<FriendRelation, Long> {
    List<FriendRelation> findAllByOwner(String username);
    FriendRelation findByOwnerAndSlave(String owner, String slave);
}
