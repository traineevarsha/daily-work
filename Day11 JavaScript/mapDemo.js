const callback = (value,index) => {
    console.log(value,index);
    return value +1;
}


function mapArrayDemo1(){
    let numbers = [1,2,3,4,5];
    
    console.log(numbers);
    const incremented_value = numbers.map(callback);
    console.log(incremented_value);
}
MapArraydemo1();