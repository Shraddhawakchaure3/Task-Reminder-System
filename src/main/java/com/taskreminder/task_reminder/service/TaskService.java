package com.taskreminder.task_reminder.service;

import com.taskreminder.task_reminder.entity.Task;
import com.taskreminder.task_reminder.enums.TaskStatus;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);

    Task addTask(Task task);

    List<Task> getAllTasks();

    Task updateTask(Long id, Task task);

    void deleteTask(Long id);

    Task markTaskCompleted(Long id);

   TaskStatus getTaskStatus(Long id);
}
