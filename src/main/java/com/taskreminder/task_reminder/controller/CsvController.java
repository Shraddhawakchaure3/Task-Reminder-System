package com.taskreminder.task_reminder.controller;

import com.taskreminder.task_reminder.utils.CsvUtil;
import com.taskreminder.task_reminder.repository.TaskRepository;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/reports")
public class CsvController {

    private final TaskRepository taskRepository;

    public CsvController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping("/export")
    public ResponseEntity<InputStreamResource> exportCsv() {

        ByteArrayInputStream csv =
                CsvUtil.generateCsv(taskRepository.findAll());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=tasks.csv");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(new InputStreamResource(csv));
    }
}
