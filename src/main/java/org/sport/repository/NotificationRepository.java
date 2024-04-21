package org.sport.repository;

import org.sport.domain.Notification;
import org.sport.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findAllByRecipient(String recipient);
    void deleteAllByRecipient(String recipient);
}
