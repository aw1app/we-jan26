import { useState } from "react";


const CounterF = () => {
//  let counter = 0;

const [counter, setCounter ] =useState(1000); // contour is now a state variable.


const increment= ()=> {    
    //counter=counter+1; // won't work. react doesn't allow direct manipulation of state variable
    setCounter(counter+1);
}

const decrement= ()=> {  
    setCounter( counter => counter-1);
}


    return(

        <div>
            Counter : {counter}

            <button style={{ "border":"solid 2px blue" }} onClick={increment} > INCREMENT </button>
            <button style={{ "border":"solid 2px blue" }} onClick={decrement} > DECREMENT </button>
        </div>

    )

};


export default CounterF;

// TASK 6 - Implement a textfeild and a button click which will increase the counter value by whatever 
// the user has typed in the textfeild

