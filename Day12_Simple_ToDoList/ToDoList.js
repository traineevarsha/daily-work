let todos = JSON.parse(localStorage.getItem('todos')) || [];

function saveTodos() {
    localStorage.setItem('todos', JSON.stringify(todos));
}

function addTodo() {
    const input = document.getElementById("todo-input");
    const time_input = document.getElementById("todo-time-input");
    const hours_taken = document.getElementById("todo-hours-input");
    const selectedPriority = document.querySelector('input[name="priority"]:checked');
    const text = input.value.trim();
    const time = time_input.value;
    const hours = hours_taken.value;
    const priority = selectedPriority ? selectedPriority.value : "";

    if (text === "") return;
    if (time === "") return;
    if (hours === "") return;
    if (priority === "") return;

    todos.push({
        text: text,
        time_input: time,
        hours: hours,
        priority: priority,
        completed: false
    });
    input.value = "";
    time_input.value = "";
    hours_taken.value = "";
    if (selectedPriority) {
        selectedPriority.checked = false;
    }
    saveTodos();
    renderTodos();
}
function sortByName(){
    todos.sort((a,b) => {
        return a.text.localeCompare(b.text);
    })
    console.log(todos);
    saveTodos();
    renderTodos();
    
}
function deleteTodo(index) {
    todos.splice(index, 1);
    saveTodos();
    renderTodos();
}
function toggleComplete(index) {
    todos[index].completed = !todos[index].completed;
    saveTodos();
    renderTodos();
}
function renderTodos() {
    const list = document.getElementById("todo-list");
    list.innerHTML = "";
    todos.forEach((todo, index) => {
        const li = document.createElement("li");
        if (todo.completed) li.classList.add("completed");
        li.innerHTML = `
            <span>${todo.text}</span>
            <span>${todo.time_input}</span>
            <span>${todo.hours}</span>
            <span>${todo.priority}</span>
            <div class="actions">
                <button class="tick-mark" onclick="toggleComplete(${index})">✔</button>
                <button class="cross-mark" onclick="deleteTodo(${index})">X</button>
            </div>
        `;
        list.appendChild(li);
    });
}
renderTodos();