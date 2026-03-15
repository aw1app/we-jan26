
import { useState } from "react";
import Product from "../product/Product";
import { useContext } from "react";
import { ProductContext } from "../../contexts/ProductContext";

const Products = (props) => {

    const {products } = useContext(ProductContext);
    

    return (
        <div style={{ border: "2px double yellow", padding: "4px", margin: "10px" }}>
            <h3>Products List </h3>

            {
                products.map(
                    (product, index) => (<Product key={index} name={product.name} price={product.price} />)
                )
            }

        </div>
    )

}


export default Products;