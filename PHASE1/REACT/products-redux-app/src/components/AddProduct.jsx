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
        <form onSubmit={handleSubmit}>
            <h3>Add Product</h3>
            <input
                placeholder="Name"
                value={name}
                onChange={(e) => setName(e.target.value)}
            />
            <input
                placeholder="Price"
                value={price}
                onChange={(e) => setPrice(e.target.value)}
            />
            <button type="submit">Add</button>
        </form>
    );
}

export default AddProduct;