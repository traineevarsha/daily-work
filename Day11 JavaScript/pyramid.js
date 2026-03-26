function printPyramid() {
    let n = 4;
    for (let row = n; row >= 1; row--) {
        let output = ""; 
        for (let column = 1; column <= row; column++) {
            output += "*";
        }
        console.log(output);
    }
}

printPyramid();


