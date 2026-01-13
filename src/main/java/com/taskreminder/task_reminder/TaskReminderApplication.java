package com.taskreminder.task_reminder;

import com.taskreminder.task_reminder.scheduler.CoreJavaScheduler;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TaskReminderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskReminderApplication.class, args);
	}

	@PostConstruct
	public void startCoreScheduler() {
		CoreJavaScheduler.start();
	}
}
