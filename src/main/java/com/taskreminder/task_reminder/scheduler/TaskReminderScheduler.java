package com.taskreminder.task_reminder.scheduler;

import com.taskreminder.task_reminder.entity.Task;
import com.taskreminder.task_reminder.enums.TaskStatus;
import com.taskreminder.task_reminder.repository.TaskRepository;
import com.taskreminder.task_reminder.service.EmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskReminderScheduler {

    private final TaskRepository repo;
    private final EmailService emailService;

    public TaskReminderScheduler(TaskRepository repo, EmailService emailService) {
        this.repo = repo;
        this.emailService = emailService;
    }

    @Scheduled (fixedDelay = 60000) // every 1 minute
    public void sendReminders() {
        List<Task> tasks = repo.findByStatus(TaskStatus.PENDING);
        tasks.forEach(emailService::sendReminder);
    }
}
