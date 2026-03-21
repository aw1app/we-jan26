import { useState, useContext } from "react";
import { ProductContext } from "../../contexts/ProductContext";

const AddProduct = () => {

    const { addProduct } = useContext(ProductContext);

    const [name, setName] = useState("Dell Monitor");
    const [price, setPrice] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault(); // prevent submiiting to backend webserver

        addProduct(name, Number(price));

        setName("");
        setPrice("");
    };

    return (
        <div style={{ border: "1px solid green", padding: "10px" }}>

            <h3>Add Product Form </h3>

            <form onSubmit={handleSubmit}>

                <input  value={name}  onChange={(e) => setName(e.target.value)}  />

                <input type="number"  value={price}   onChange={(e) => setPrice(e.target.value)}     />

                <button type="submit">Add</button>

            </form>

            Name: {name}, Price {price}

        </div>
    );
}

export default AddProduct;