function validate(object,requiredKeys){
    return requiredKeys.every(key => key in object);
}
const data = {name:"john",age: 25};
console.log(validate(data,["name","age","email"]));
