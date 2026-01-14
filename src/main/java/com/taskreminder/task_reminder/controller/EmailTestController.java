package com.taskreminder.task_reminder.controller;

import com.taskreminder.task_reminder.service.EmailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailTestController {

    private final EmailService emailService;

    public EmailTestController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/test")
    public String testMail() {
        emailService.sendReminder(
                "shrawakchaure@gmail.com",
                "Task Reminder Test",
                "This is a test email from Task Reminder Application"
        );
        return "Mail sent successfully";
    }
}
