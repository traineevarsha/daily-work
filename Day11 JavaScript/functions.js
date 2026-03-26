//let sum = 0;
function add(a,b){
    let sum = 0;
    console.log(arguments);
    for (let index = 0; index<arguments.length; index++){
        sum+= arguments[index];
    }
    return sum;
}
const result = add(1,2,1,7);
console.log(result);
