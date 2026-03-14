import { Component } from "react";
import ProductC from "../product/ProductC";

class Products extends Component {


    constructor(props) {
        super(props);

        this.state = {
            products: props.products
        }
    }



    render() {

        return (
              <div style={{ border: "2px double yellow", padding: "4px", margin: "10px" }}>
                <h3>Products List </h3>

                {
                    this.state.products.map(
                        product => (<ProductC name={product.name} price={product.price} />)
                    )
                }


            </div>


        )
    }
}


export default Products;