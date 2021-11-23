package com.brm.ReactiveDemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This controller handles navigation within the application.
 */
@Controller
public class NavigationController {

    @GetMapping("/view-notifications")
    public String viewNotificationsHome() {
        return "view-notifications/view-notifications";
    }

    @GetMapping("/send-notification")
    public String sendNotificationHome() {
        return "send-notification/send-notification";
    }
}
