const addAsArrow = (numbers) => {
    let sum = 0;
    for (let index =0; index<numbers.length;index++){
        sum += numbers[index];
    }
    return sum;
}

console.log(addAsArrow([1,2,5]));