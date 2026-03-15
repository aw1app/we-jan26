

const ProductF = (props) => {
    let conversionRate = 10;

    // returning JSX
    return (
        <div style={{"border":"solid 1px blue"}}>
          
            Name : {props.name}, Price : USD {props.price * conversionRate}

            <button onClick={props.f1}> Click Me to Invoke f1 function passed by the Parent</button>
        </div>
    )
}

export default ProductF;


