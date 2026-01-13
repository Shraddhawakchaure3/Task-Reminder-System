package com.taskreminder.task_reminder.controller;

import com.taskreminder.task_reminder.enums.TaskStatus;
import com.taskreminder.task_reminder.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final TaskRepository taskRepository;

    public ReportController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/overview")
    public Map<String, Long> getOverview() {
        Map<String, Long> overview = new HashMap<>();
        overview.put("totalTasks", taskRepository.count());
        overview.put("pendingTasks",
                (long) taskRepository.findByStatus(TaskStatus.PENDING).size());
        overview.put("completedTasks",
                (long) taskRepository.findByStatus(TaskStatus.COMPLETED).size());
        return overview;
    }
}
