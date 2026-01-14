package com.taskreminder.task_reminder.utils;

import com.taskreminder.task_reminder.entity.Task;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsvUtil {

    public static ByteArrayInputStream generateCsv(List<Task> tasks) {

        final CSVFormat format = CSVFormat.DEFAULT
                .withHeader("ID", "Title", "Due Date", "Email", "Status");

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter printer = new CSVPrinter(new PrintWriter(out), format)) {

            for (Task task : tasks) {
                printer.printRecord(
                        task.getId(),
                        task.getTitle(),      // ✅ was getName()
                        task.getDueDate(),    // ✅ was getDueBy()
                        task.getEmail(),      // ✅ was getUserName()
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
