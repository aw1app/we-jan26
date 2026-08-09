import React, { useState, useEffect, useContext } from 'react';
import { useParams, Link } from 'react-router-dom';
import axios from 'axios';
import { CartContext } from '../context/CartContext';

export const Dishes = () => {
    const { restaurantId } = useParams();
    const [dishes, setDishes] = useState([]);
    const [message, setMessage] = useState('');
    const { addToCart } = useContext(CartContext);

    useEffect(() => {
        const url = restaurantId
            ? `http://localhost:8080/api/dishes/restaurant/${restaurantId}`
            : 'http://localhost:8080/api/dishes';

        axios.get(url)
            .then(res => setDishes(res.data))
            .catch(() => {
                setDishes([
                    { id: '101', name: 'Burger', description: 'Veg Burger', price: 140, ingredients: ['Patty', 'Bun', 'White Sauce'] },
                    { id: '102', name: 'Paneer Butter Masala', description: 'Rich gravy', price: 280, ingredients: ['Paneer', 'Butter', 'Spices'] }
                ]);
            });
    }, [restaurantId]);

    const handleAddToCart = (dish) => {
        addToCart(dish);
        setMessage(`Added ${dish.name} to shopping cart!`);
        setTimeout(() => setMessage(''), 3000);
    };

    return (
        <div className="container">
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '1.5rem' }}>
                <h2>Dishes</h2>
                <Link to="/restaurants" className="btn btn-secondary btn-sm">Back to Restaurants</Link>
            </div>

            {message && <div className="alert alert-success">{message}</div>}

            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(300px, 1fr))', gap: '1.5rem' }}>
                {dishes.map(dish => (
                    <div key={dish.id} className="card">
                        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start' }}>
                            <div>
                                <h3 style={{ marginBottom: '0.25rem' }}>{dish.name}</h3>
                                <p style={{ color: '#666', fontSize: '0.85rem', marginBottom: '0.5rem' }}>{dish.description}</p>
                            </div>
                            <span style={{ fontWeight: '700', fontSize: '1.1rem', color: '#333' }}>₹{dish.price}</span>
                        </div>

                        <div style={{ marginTop: '0.5rem', marginBottom: '1rem' }}>
                            <p style={{ fontSize: '0.8rem', color: '#888', marginBottom: '0.25rem' }}>Ingredients:</p>
                            {dish.ingredients && dish.ingredients.map((ing, idx) => (
                                <span key={idx} className="ingredient-badge">{ing}</span>
                            ))}
                        </div>

                        <button onClick={() => handleAddToCart(dish)} className="btn btn-primary btn-sm" style={{ width: '100%', marginTop: '0.5rem' }}>
                            Add To Cart
                        </button>
                    </div>
                ))}
            </div>
        </div>
    );
};
