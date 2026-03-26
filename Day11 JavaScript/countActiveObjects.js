const users = [
    { id: 1, name: "A", Active: true },
    { id: 2, name: "B", Active: false },
    { id: 3, name: "C", Active: true },
    { id: 4, name: "D", Active: true }
];

function toggleUsers(users) {
    for (let i = 0; i < users.length; i++) {

        if (users[i].Active === true) {
            users[i].Active = false;
        } else {
            users[i].Active = true;
        }

    }

    return users;
}

console.log(toggleUsers(users));