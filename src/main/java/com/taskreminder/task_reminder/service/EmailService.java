package com.taskreminder.task_reminder.service;

import com.taskreminder.task_reminder.entity.Task;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendReminder(Task task) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(task.getEmail());
        message.setSubject("Task Reminder");
        message.setText("Reminder: Task '" + task.getName() + "' is still pending.");

        mailSender.send(message);
    }
}
