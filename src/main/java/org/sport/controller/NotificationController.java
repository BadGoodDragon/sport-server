package org.sport.controller;

import lombok.RequiredArgsConstructor;
import org.sport.domain.Notification;
import org.sport.domain.User;
import org.sport.service.NotificationService;
import org.sport.service.UserService;
import org.sport.util.Authorization;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    private final UserService userService;

    private final String[] tasks = {
            "Присядь 15 раз!",
            "Отожмись 10 раз!",
            "Сделай 5-минутную пробежку!",
            "Подтянись 5 раз!",
            "Подними 10 раз гантелю!"
    };

    @GetMapping("/notification")
    private List<Notification> getNotifications(@RequestHeader("Authorization") String bearerToken) {
        String token = Authorization.parseBearer(bearerToken);
        String username = userService.getByToken(token).getUsername();

        List<Notification> notifications = notificationService.getAndDelete(username);

        return notifications;
    }

    @GetMapping("/notificationBasic")
    private List<Notification> getNotificationsBasic(@RequestHeader("Authorization") String authorization) {
        String username = userService.getByName(Authorization.parseBasicUsername(authorization)).getUsername();

        List<Notification> notifications = notificationService.getAndDelete(username);

        return notifications;
    }

    @PostMapping("/notification")
    private void addNotification(@RequestHeader("Authorization") String bearerToken, @RequestParam(name = "receiver") String receiver) {
        String token = Authorization.parseBearer(bearerToken);
        User user = userService.getByToken(token);

        if (user == null) {
            throw new RuntimeException("Такого пользователя не существует!");
        }

        // Добавление уведомления
        notificationService.add(receiver, user.getUsername(), getRandomTask());
    }

    @PostMapping("/notificationBasic")
    private void addNotificationBasic(@RequestHeader("Authorization") String authorization, @RequestParam(name = "receiver") String receiver) {

        User user = userService.getByName(Authorization.parseBasicUsername(authorization));

        if (user == null) {
            throw new RuntimeException("Такого пользователя не существует!");
        }

        // Добавление уведомления
        notificationService.add(receiver, user.getUsername(), getRandomTask());
    }

    private String getRandomTask() {
        Random random = new Random();
        int randomIndex = random.nextInt(tasks.length);

        return tasks[randomIndex];
    }
}
