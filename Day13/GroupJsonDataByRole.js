const users = [
    {name:"A", role:"Admin", salary: 4000},
    {name:"B",role:"user",salary:4000},
    {name:"c", role: "user", salary: 5000},
    {name:"D",role:"user",salary:4000.01},
];
function groupBySalary(users){
const groupedSalary = users.reduce((result,user) => {
    if(!result[user.salary]) 
        result[user.salary] = [];
    result[user.salary].push(user);
    return result;
}, {});
return groupedSalary;
}

function groupByRole(users){
const grouped = users.reduce((result,user) => {
    if(!result[user.role]) 
        result[user.role] = [];
    result[user.role].push(user);
    return result;
}, {});
}

console.log(groupBySalary(users));
