

function Product(props) {
    let name = "HP Monitor";
    let price = 50000;

    // returning JSX
    return (
        <div>
          
            Name : {props.name}, Price : {props.price}
        </div>
    )
}

export default Product;


