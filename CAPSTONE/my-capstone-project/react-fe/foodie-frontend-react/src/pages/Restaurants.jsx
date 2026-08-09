import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

export const Restaurants = () => {
    const [restaurants, setRestaurants] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/restaurants')
            .then(res => setRestaurants(res.data))
            .catch(() => {
                setRestaurants([
                    { id: '1', name: 'Test Restaurant', cuisine: 'Indian', address: 'ABC Street', email: 'test@res.com', contact: '1234567890', rating: 4.5 },
                    { id: '2', name: 'Foodie Express', cuisine: 'Italian & Fast Food', address: '456 Market Road', email: 'express@foodie.com', contact: '9876543210', rating: 4.8 }
                ]);
            });
    }, []);

    return (
        <div className="container">
            <h2 style={{ marginBottom: '1.5rem', color: '#333', fontWeight: '600' }}>Restaurants</h2>

            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(320px, 1fr))', gap: '1.5rem' }}>
                {restaurants.map(restaurant => (
                    <div key={restaurant.id} className="card">
                        <h3 style={{ color: '#b01c2e', marginBottom: '0.5rem' }}>{restaurant.name}</h3>
                        <p style={{ color: '#666', fontSize: '0.9rem', marginBottom: '1rem' }}>{restaurant.cuisine}</p>

                        <div style={{ fontSize: '0.9rem', marginBottom: '1rem', color: '#444' }}>
                            <p><strong>Contact Information</strong></p>
                            <p><i className="fa fa-map-marker-alt" style={{ marginRight: '6px', color: '#dc3545' }}></i> {restaurant.address}</p>
                            <p><i className="fa fa-envelope" style={{ marginRight: '6px', color: '#dc3545' }}></i> {restaurant.email}</p>
                            <p><i className="fa fa-phone" style={{ marginRight: '6px', color: '#dc3545' }}></i> {restaurant.contact}</p>
                        </div>

                        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginTop: '1rem' }}>
              <span style={{ background: '#e9ecef', padding: '4px 10px', borderRadius: '12px', fontWeight: '600', fontSize: '0.85rem', color: '#333' }}>
                <i className="fa fa-star" style={{ color: '#ffc107' }}></i> {restaurant.rating || 4.5}
              </span>
                            <Link to={`/restaurants/${restaurant.id}/dishes`} className="btn btn-primary btn-sm">
                                View Dishes
                            </Link>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};
