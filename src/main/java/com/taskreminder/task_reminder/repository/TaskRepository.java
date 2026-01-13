package com.taskreminder.task_reminder.repository;

import com.taskreminder.task_reminder.entity.Task;
import com.taskreminder.task_reminder.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus status);

    List<Task> findByUserName(String userName);
}
