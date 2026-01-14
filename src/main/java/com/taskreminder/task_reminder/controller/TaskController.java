package com.taskreminder.task_reminder.controller;

import com.taskreminder.task_reminder.entity.Task;
import com.taskreminder.task_reminder.enums.TaskStatus;
import com.taskreminder.task_reminder.service.TaskService;
import com.taskreminder.task_reminder.utils.CsvUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // ✅ ADD TASK
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    // ✅ GET ALL TASKS
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // ✅ MARK TASK COMPLETED
    @PutMapping("/{id}/complete")
    public Task markCompleted(@PathVariable Long id) {
        return taskService.markTaskCompleted(id);
    }

    // ✅ GET TASK STATUS
    @GetMapping("/{id}/status")
    public TaskStatus getStatus(@PathVariable Long id) {
        return taskService.getTaskStatus(id);
    }

    // ✅ DELETE TASK
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    // ✅ EXPORT CSV
    @GetMapping("/export")
    public ResponseEntity<byte[]> exportCsv() {

        List<Task> tasks = taskService.getAllTasks();
        ByteArrayInputStream csv = CsvUtil.generateCsv(tasks);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=tasks.csv")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(csv.readAllBytes());
    }
}
