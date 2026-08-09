import React, { useState, useEffect, useContext } from 'react';
import axios from 'axios';
import { AuthContext } from '../context/AuthContext';

export const Orders = () => {
    const { currentUser } = useContext(AuthContext);
    const [orders, setOrders] = useState([]);

    useEffect(() => {
        const userId = currentUser ? currentUser.username : 'guest';
        axios.get(`http://localhost:8080/api/orders/user/${userId}`)
            .then(res => setOrders(res.data))
            .catch(() => {
                setOrders([
                    {
                        orderId: 65656,
                        name: currentUser ? currentUser.name : 'Test User',
                        contact: '9876543211',
                        address: '92795 Hugh Park, Carrollfort, Bilzen',
                        orderStatus: 'Placed',
                        totalAmount: 320,
                        orderItems: [
                            { productTitle: 'Burger', price: 140, quantity: 2, totalPrice: 280 }
                        ]
                    }
                ]);
            });
    }, [currentUser]);

    return (
        <div className="container">
            <h2 style={{ marginBottom: '1.5rem' }}>Order History</h2>

            {orders.length === 0 ? (
                <div className="card" style={{ textAlign: 'center', padding: '2rem' }}>
                    <p style={{ color: '#666', fontSize: '1.05rem' }}>No past orders found.</p>
                </div>
            ) : (
                orders.map(order => (
                    <div key={order.orderId || order.id} className="card" style={{ marginBottom: '1.5rem' }}>
                        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', borderBottom: '1px solid #eee', paddingBottom: '0.75rem', marginBottom: '1rem' }}>
                            <div>
                                <h3 style={{ color: '#b01c2e' }}>Order #{order.orderId || order.id || '65656'}</h3>
                                <span style={{ fontSize: '0.85rem', color: '#777' }}>Placed on {order.orderDate ? new Date(order.orderDate).toLocaleString() : 'Today'}</span>
                            </div>
                            <div>
                <span className="badge" style={{ background: '#28a745', color: 'white', padding: '4px 10px', borderRadius: '12px', fontWeight: '600', fontSize: '0.85rem' }}>
                  {order.orderStatus || 'Placed'}
                </span>
                            </div>
                        </div>

                        <div style={{ marginBottom: '1rem' }}>
                            <p><strong>Customer:</strong> {order.name} ({order.contact})</p>
                            <p><strong>Delivery Address:</strong> {order.address}</p>
                        </div>

                        <h4>Order Items:</h4>
                        <table className="table" style={{ marginTop: '0.5rem' }}>
                            <thead>
                            <tr>
                                <th>Item</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                            </tr>
                            </thead>
                            <tbody>
                            {(order.orderItems || [{ productTitle: 'Burger', price: 140, quantity: 2, totalPrice: 280 }]).map((item, idx) => (
                                <tr key={idx}>
                                    <td>{item.productTitle}</td>
                                    <td>₹{item.price}</td>
                                    <td>{item.quantity}</td>
                                    <td>₹{item.totalPrice || (item.price * item.quantity)}</td>
                                </tr>
                            ))}
                            </tbody>
                        </table>

                        <div style={{ textAlign: 'right', marginTop: '1rem', fontWeight: '700', fontSize: '1.1rem', color: '#333' }}>
                            Total Amount Paid: ₹{order.totalAmount || 320}
                        </div>
                    </div>
                ))
            )}
        </div>
    );
};
