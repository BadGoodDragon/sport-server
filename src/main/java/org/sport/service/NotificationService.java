package org.sport.service;

import org.sport.domain.Notification;

import java.util.List;

public interface NotificationService {
    void add(String recipient, String author, String data);
    List<Notification> getAndDelete(String username);

}
