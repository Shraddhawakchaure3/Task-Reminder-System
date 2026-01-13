package com.taskreminder.task_reminder.utils;

import com.taskreminder.task_reminder.entity.Task;
import org.apache.commons.csv.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;


import java.io.*;
import java.util.List;

public class CsvUtil {

    public static ByteArrayInputStream generateCsv(List<Task> tasks) {

        final CSVFormat format = CSVFormat.DEFAULT
                .withHeader("ID", "Name", "Due Date", "User", "Email", "Status");

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter printer = new CSVPrinter(
                     new PrintWriter(out), format)) {

            for (Task task : tasks) {
                printer.printRecord(
                        task.getId(),
                        task.getName(),
                        task.getDueBy(),
                        task.getUserName(),
                        task.getEmail(),
                        task.getStatus()
                );
            }
            printer.flush();
            return new ByteArrayInputStream(out.toByteArray());

        } catch (IOException e) {
            throw new RuntimeException("Failed to generate CSV", e);
        }
    }
}