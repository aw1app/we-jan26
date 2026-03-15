import { useState } from "react";


const CounterF = () => {
//  let counter = 0;

const [counter, setCounter ] =useState(1000); // contour is now a state variable.


const increment= ()=> {
    console.log("INSIDE increment of CounterF");
    //counter=counter+1; // won't work. react doesn't allow direct manipulation of state variable
    setCounter(counter+1);
}


    return(

        <div>
            Counter : {counter}

            <button style={{ "border":"solid 2px blue" }} onClick={increment} > INCREMENT </button>
        </div>

    )

};


export default CounterF;


// TASK5- Implemnent decrement counter functionality