import { useState, useContext } from "react";
import { ProductContext } from "../../contexts/ProductContext";

const AddProduct = () => {

    const { addProduct } = useContext(ProductContext);

    const [name, setName] = useState("");
    const [price, setPrice] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();

        addProduct(name, Number(price));

        setName("");
        setPrice("");
    };

    return (
        <div style={{ border: "1px solid green", padding: "10px" }}>

            <h3>Add Product</h3>

            <form onSubmit={handleSubmit}>

                <input
                    type="text"
                    placeholder="Product Name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />

                <input
                    type="number"
                    placeholder="Price"
                    value={price}
                    onChange={(e) => setPrice(e.target.value)}
                />

                <button type="submit">Add</button>

            </form>

        </div>
    );
}

export default AddProduct;