package com.taskreminder.task_reminder.service.impl;

import com.taskreminder.task_reminder.entity.Task;
import com.taskreminder.task_reminder.enums.TaskStatus;
import com.taskreminder.task_reminder.repository.TaskRepository;
import com.taskreminder.task_reminder.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // ✅ Create Task
    @Override
    public Task createTask(Task task) {
        task.setStatus(TaskStatus.PENDING);
        task.setCompleted(false);
        return taskRepository.save(task);
    }

    // (Optional duplicate – you can REMOVE addTask if not needed)
    @Override
    public Task addTask(Task task) {
        task.setStatus(TaskStatus.PENDING);
        task.setCompleted(false);
        return taskRepository.save(task);
    }


    // ✅ Get all tasks
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // ✅ Update task
    @Override
    public Task updateTask(Long id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setDueDate(updatedTask.getDueDate());

        return taskRepository.save(existingTask);
    }

    // ✅ Delete task
    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // ✅ Mark task completed (FIXED return type)
    @Override
    public Task markTaskCompleted(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(TaskStatus.COMPLETED);
        task.setCompleted(true);
        task.setCompletedAt(LocalDateTime.now());

        return taskRepository.save(task);
    }

    // ✅ Get task status
    @Override
    public TaskStatus getTaskStatus(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"))
                .getStatus();
    }
}
