

function Product(props) {
    let conversionRate = 90;

    // returning JSX
    return (
        <div>
          
            Name : {props.name}, Price : INR {props.price * conversionRate}
        </div>
    )
}

export default Product;


