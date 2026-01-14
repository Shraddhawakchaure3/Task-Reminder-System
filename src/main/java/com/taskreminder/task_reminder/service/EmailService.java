package com.taskreminder.task_reminder.service;

public interface EmailService {
    void sendReminder(String to, String subject, String body);
}
