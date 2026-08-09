import React, { useContext } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { AuthContext } from '../context/AuthContext';
import { CartContext } from '../context/CartContext';

export const Navbar = () => {
    const { currentUser, logout } = useContext(AuthContext);
    const { cartCount } = useContext(CartContext);
    const navigate = useNavigate();

    const handleLogout = () => {
        logout();
        navigate('/login');
    };

    return (
        <nav className="bg-danger-custom" style={{ padding: '0.8rem 2rem', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
            <div style={{ display: 'flex', alignItems: 'center', gap: '1.5rem' }}>
                <Link to="/" className="brand-title">FOODIE INC (React)</Link>
                <Link to="/restaurants" className="nav-link-custom">Restaurants</Link>
                {currentUser && (
                    <>
                        <Link to="/cart" className="nav-link-custom">
                            Shopping Cart <span className="badge-cart">{cartCount}</span>
                        </Link>
                        <Link to="/my-orders" className="nav-link-custom">My Orders</Link>
                        <Link to="/profile" className="nav-link-custom">My Profile</Link>
                    </>
                )}
            </div>
            <div>
                {currentUser ? (
                    <>
            <span style={{ color: 'white', marginRight: '1rem', fontWeight: '500' }}>
              Welcome, {currentUser.name || currentUser.username}
            </span>
                        <button onClick={handleLogout} className="btn btn-sm btn-secondary">Logout</button>
                    </>
                ) : (
                    <>
                        <Link to="/login" className="nav-link-custom">Login</Link>
                        <Link to="/register" className="nav-link-custom">Register</Link>
                    </>
                )}
            </div>
        </nav>
    );
};
