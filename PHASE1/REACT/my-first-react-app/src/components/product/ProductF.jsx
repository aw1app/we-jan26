

function ProductF(props) {
    let conversionRate = 10;

    // returning JSX
    return (
        <div style={{"border":"solid 1px blue"}}>
          
            Name : {props.name}, Price : USD {props.price * conversionRate}
        </div>
    )
}

export default ProductF;


