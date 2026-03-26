let tasks = [];

function addTask() {
    let input = document.getElementById("taskInput");
    let taskText = input.value
    if (taskText === "") return;
    tasks.push(taskText);
    localStorage.setItem("tasks", JSON.stringify(tasks));
    input.value = "";
    renderTasks();
}

function renderTasks() {
    let taskList = document.getElementById("taskList");
    taskList.innerHTML = "";

    for (let index = 0; index < tasks.length; index++) {
        let li = document.createElement("li");
        li.innerHTML = `${tasks[index]} 
        <button onclick="deleteTask(${index})">X</button>`;
        li.onclick = toggleComplete; 
        taskList.appendChild(li);
    }
}

function deleteTask(index) {
    tasks.splice(index, 1);
    localStorage.setItem("tasks", JSON.stringify(tasks));
    renderTasks();
}

function toggleComplete(event) {
    event.target.classList.toggle("completed");
}

window.onload = function () {
    let saved = localStorage.getItem("tasks");
    if (saved) {
        tasks = JSON.parse(saved);
        renderTasks();
    }
};