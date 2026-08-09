import React, { useContext } from 'react';
import { Link } from 'react-router-dom';
import { CartContext } from '../context/CartContext';

export const Cart = () => {
    const { cartItems, updateQuantity, removeItem, clearCart } = useContext(CartContext);

    const getSubtotal = () => {
        return cartItems.reduce((sum, item) => sum + (item.price * item.quantity), 0);
    };

    return (
        <div className="container">
            <h2 style={{ marginBottom: '1.5rem' }}>Shopping Cart</h2>

            {cartItems.length === 0 ? (
                <div className="card" style={{ textAlign: 'center', padding: '3rem' }}>
                    <p style={{ color: '#666', fontSize: '1.1rem', marginBottom: '1rem' }}>Your shopping cart is currently empty.</p>
                    <Link to="/restaurants" className="btn btn-primary">Browse Restaurants</Link>
                </div>
            ) : (
                <div className="card">
                    <table className="table">
                        <thead>
                        <tr>
                            <th>Dish</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        {cartItems.map(item => (
                            <tr key={item.cartId || item.dishId}>
                                <td><strong>{item.dishName}</strong></td>
                                <td>₹{item.price}</td>
                                <td>
                                    <button onClick={() => updateQuantity(item, -1)} className="btn btn-sm btn-secondary">-</button>
                                    <span style={{ margin: '0 10px', fontWeight: '600' }}>{item.quantity}</span>
                                    <button onClick={() => updateQuantity(item, 1)} className="btn btn-sm btn-secondary">+</button>
                                </td>
                                <td>₹{item.price * item.quantity}</td>
                                <td>
                                    <button onClick={() => removeItem(item)} className="btn btn-sm btn-danger">Remove</button>
                                </td>
                            </tr>
                        ))}
                        </tbody>
                    </table>

                    <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginTop: '1.5rem', borderTop: '2px dashed #eee', paddingTop: '1rem' }}>
                        <div>
                            <h3>Total: ₹{getSubtotal()}</h3>
                            <p style={{ fontSize: '0.85rem', color: '#777' }}>Shipping charges: ₹40</p>
                        </div>
                        <div>
                            <button onClick={clearCart} className="btn btn-secondary" style={{ marginRight: '1rem' }}>Clear Cart</button>
                            <Link to="/checkout" className="btn btn-danger">Proceed to Checkout</Link>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
};
