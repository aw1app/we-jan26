import React, { useState, useEffect, useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { AuthContext } from '../context/AuthContext';
import { CartContext } from '../context/CartContext';

export const Checkout = () => {
    const { currentUser } = useContext(AuthContext);
    const { fetchCart } = useContext(CartContext);
    const navigate = useNavigate();

    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [contact, setContact] = useState('');
    const [address, setAddress] = useState('');
    const [paymentMethod, setPaymentMethod] = useState('COD');
    const [errorMessage, setErrorMessage] = useState('');

    useEffect(() => {
        if (currentUser) {
            setName(currentUser.name || currentUser.username);
            setEmail(currentUser.email || '');
            setContact(currentUser.contact || '');
            setAddress(currentUser.address || '');
        }
    }, [currentUser]);

    const placeOrder = async (e) => {
        e.preventDefault();
        const userId = currentUser ? currentUser.username : 'guest';
        const orderData = {
            userId,
            name,
            email,
            contact,
            address,
            paymentMethod
        };

        try {
            await axios.post('http://localhost:8080/api/checkout', orderData);
            fetchCart();
            navigate('/my-orders');
        } catch (err) {
            navigate('/my-orders');
        }
    };

    return (
        <div className="container" style={{ maxWidth: '600px' }}>
            <div className="card">
                <h2 style={{ marginBottom: '1.5rem', textAlign: 'center', color: '#b01c2e' }}>Checkout Order</h2>

                {errorMessage && <div className="alert alert-danger">{errorMessage}</div>}

                <form onSubmit={placeOrder}>
                    <div className="form-group">
                        <label>Full Name</label>
                        <input type="text" value={name} onChange={(e) => setName(e.target.value)} className="form-control" placeholder="John Doe" required />
                    </div>

                    <div className="form-group">
                        <label>Email Address</label>
                        <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} className="form-control" placeholder="john@example.com" required />
                    </div>

                    <div className="form-group">
                        <label>Contact Number</label>
                        <input type="text" value={contact} onChange={(e) => setContact(e.target.value)} className="form-control" placeholder="9876543210" required />
                    </div>

                    <div className="form-group">
                        <label>Delivery Address</label>
                        <textarea value={address} onChange={(e) => setAddress(e.target.value)} className="form-control" rows="3" placeholder="Enter complete delivery address" required></textarea>
                    </div>

                    <div className="form-group">
                        <label>Payment Method</label>
                        <select value={paymentMethod} onChange={(e) => setPaymentMethod(e.target.value)} className="form-control">
                            <option value="COD">Cash On Delivery (COD)</option>
                            <option value="CARD">Credit/Debit Card</option>
                            <option value="UPI">UPI / Online Banking</option>
                        </select>
                    </div>

                    <button type="submit" className="btn btn-danger" style={{ width: '100%', padding: '0.75rem', marginTop: '1rem' }}>
                        Place Order Now
                    </button>
                </form>
            </div>
        </div>
    );
};
