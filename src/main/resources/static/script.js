const baseUrl = "http://localhost:8080";
function addTask() {
    const task = {
        title: document.getElementById("title").value,
        dueDate: document.getElementById("dueDate").value,
        email: document.getElementById("email").value
    };

    fetch("/api/tasks", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(task)
    })
    .then(res => {
        if (!res.ok) throw new Error("Failed");
        return res.json();
    })
    .then(() => {
        alert("Task added!");
        loadTasks();
    })
    .catch(err => alert(err));
}

function loadTasks() {
    fetch("/api/tasks")
        .then(res => res.json())
        .then(tasks => {
            console.log(tasks);
        });
}

// Complete Task
function completeTask(id) {
    fetch(`${baseUrl}/tasks/completion/mark/${id}`, { method: "PUT" })
        .then(() => loadTasks());
}

// Delete Task
function deleteTask(id) {
    fetch(`${baseUrl}/tasks/${id}`, { method: "DELETE" })
        .then(() => loadTasks());
}

// Overview
function loadOverview() {
    fetch("/api/tasks")
        .then(res => res.json())
        .then(tasks => {
            const total = tasks.length;
            const pending = tasks.filter(t => t.status === "PENDING").length;
            const completed = tasks.filter(t => t.status === "COMPLETED").length;

            document.getElementById("overview").innerText =
                `Total: ${total} | Pending: ${pending} | Completed: ${completed}`;

            // 🔥 IMPORTANT: reload tasks again
            loadTasks();
        });
}


// Export CSV
function exportCSV() {
    fetch(`${baseUrl}/reports/export`, { method: "POST" })
        .then(res => res.blob())
        .then(blob => {
            const url = window.URL.createObjectURL(blob);
            const a = document.createElement("a");
            a.href = url;
            a.download = "tasks.csv";
            a.click();
        });
}
