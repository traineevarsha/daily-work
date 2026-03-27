const user = [
    {name:"A", role: "admin" },
    {name: "B" , role: "user"},
    {name: "c", role: "admin"}
];

const frequency = user.reduce((result,user) => {
    result[user.role] = (result[user.role] || 0) +1; //if result has a role then true else 0
    return result;
} , {});
console.log(frequency);
 
