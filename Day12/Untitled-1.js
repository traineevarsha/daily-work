setTimeout (() => { 
    console.log("Step 1");
    setTimeout(() => {
        console.log("step 2");
            setTimeout (() => { 
                console.log("Step 1");
            },1000); 
    },1000);
},1000)