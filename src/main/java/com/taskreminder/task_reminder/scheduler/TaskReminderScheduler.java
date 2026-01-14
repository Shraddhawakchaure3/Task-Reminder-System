package com.taskreminder.task_reminder.scheduler;

import com.taskreminder.task_reminder.entity.Task;
import com.taskreminder.task_reminder.repository.TaskRepository;
import com.taskreminder.task_reminder.service.EmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskReminderScheduler {

    private final TaskRepository taskRepository;
    private final EmailService emailService;

    public TaskReminderScheduler(TaskRepository taskRepository,
                                 EmailService emailService) {
        this.taskRepository = taskRepository;
        this.emailService = emailService;
    }

    @Scheduled(fixedRate = 60000)
    public void sendTaskReminders() {
        System.out.println("Scheduler running...");
    }

}
