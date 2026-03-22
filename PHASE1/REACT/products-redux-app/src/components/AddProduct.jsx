import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { addProduct } from '../slices/productsSlice';

function AddProduct() {
    const [name, setName] = useState('');
    const [price, setPrice] = useState('');


    const dispatch = useDispatch();

    const handleSubmit = (e) => {
        e.preventDefault();

        const newProduct = {
            name,
            price,
            description: '',
            inStock: true,
            imagePath: '',
        };

        dispatch(addProduct(newProduct));

        setName('');
        setPrice('');
    };

    return (
        <div className="container">
            <div className="card">
                <h2>Add Product</h2>

                <form onSubmit={handleSubmit} className="form">
                    <input
                        placeholder="Product Name"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                    />

                    <input
                        placeholder="Price"
                        value={price}
                        onChange={(e) => setPrice(e.target.value)}
                    />

                    <button type="submit">Add Product</button>
                </form>
            </div>
        </div>
    );
}

export default AddProduct;