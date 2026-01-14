package com.taskreminder.task_reminder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
		properties = "spring.mail.test-connection=false"
)
class TaskReminderApplicationTests {

	@Test
	void contextLoads() {
		// App context loads successfully
	}
}
