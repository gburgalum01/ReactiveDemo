package com.brm.ReactiveDemo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a notification to be transmitted as a server-sent event.
 */
public class Notification {

    @JsonProperty("USER")
    private String user;

    @JsonProperty("NOTIFICATION")
    private String notification;

    public Notification(String user, String notification) {
        this.user = user;
        this.notification = notification;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    @Override
    public String toString() {
        return "[user = " + user + "; notification = " + notification + "]";
    }
}
