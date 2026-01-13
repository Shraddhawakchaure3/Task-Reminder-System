package com.taskreminder.task_reminder.service.impl;

import com.taskreminder.task_reminder.entity.Task;
import com.taskreminder.task_reminder.enums.TaskStatus;
import com.taskreminder.task_reminder.repository.TaskRepository;
import com.taskreminder.task_reminder.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        task.setStatus(TaskStatus.CREATED);
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setName(updatedTask.getName());
        task.setDueBy(updatedTask.getDueBy());
        task.setUserName(updatedTask.getUserName());
        task.setEmail(updatedTask.getEmail());

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus(TaskStatus.DELETED);
        taskRepository.save(task);
    }

    @Override
    public Task markTaskCompleted(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus(TaskStatus.COMPLETED);
        return taskRepository.save(task);
    }

    @Override
    public TaskStatus getTaskStatus(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"))
                .getStatus();
    }
}
