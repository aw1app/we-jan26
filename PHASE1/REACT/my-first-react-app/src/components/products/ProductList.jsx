import { Component } from "react";
import ProductC from "../product/ProductC";

class ProductList extends Component {


    constructor(props) {
        super(props);

        this.state = {
            products: props.items
        }
    }



    render() {

        return (
              <div style={{ border: "2px double yellow", padding: "4px", margin: "10px" }}>
                <h3>Products List from Products comp</h3>

                {
                    this.state.products.map(
                        (product,index) => (<ProductC id={index} name={product.name} price={product.price} />)
                    )
                }

            </div>


        )
    }
}


export default ProductList;