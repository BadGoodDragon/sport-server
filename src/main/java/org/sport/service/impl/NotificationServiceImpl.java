package org.sport.service.impl;


import lombok.RequiredArgsConstructor;
import org.sport.domain.Notification;
import org.sport.repository.NotificationRepository;
import org.sport.service.NotificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;

    @Override
    public void add(String recipient, String author, String data) {
        Notification notification = Notification.builder().recipient(recipient).author(author).data(data).build();
        notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getAndDelete(String username) {
        List<Notification> result = notificationRepository.findAllByRecipient(username);
        notificationRepository.deleteAllByRecipient(username);
        return result;
    }
}
