import React, { useState, useContext } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { AuthContext } from '../context/AuthContext';

export const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState('');

    const { login } = useContext(AuthContext);
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        const res = await login({ username, password });
        if (res.success) {
            navigate('/restaurants');
        } else {
            setErrorMessage(res.error);
        }
    };

    return (
        <div style={{ display: 'flex', minHeight: '85vh', background: '#fff' }}>
            <div style={{ flex: 1, background: '#b01c2e', color: 'white', display: 'flex', flexDirection: 'column', justifyContent: 'center', padding: '4rem' }}>
                <h1 style={{ fontSize: '2.8rem', fontWeight: '700', marginBottom: '1rem' }}>FOOD INC. STORE</h1>
                <p style={{ fontSize: '1.2rem', opacity: '0.9' }}>React + Vite Frontend</p>
                <p style={{ fontSize: '1rem', opacity: '0.8', marginTop: '0.5rem' }}>An Optimal, Reliable and Dynamic Web Backend</p>
            </div>

            <div style={{ flex: 1, display: 'flex', alignItems: 'center', justifyContent: 'center', padding: '2rem' }}>
                <div style={{ width: '100%', maxWidth: '400px' }} className="card">
                    <h2 style={{ textAlign: 'center', marginBottom: '1.5rem', fontWeight: '600' }}>Login</h2>

                    {errorMessage && <div className="alert alert-danger">{errorMessage}</div>}

                    <form onSubmit={handleSubmit}>
                        <div className="form-group">
                            <label>Username / Email</label>
                            <input
                                type="text"
                                value={username}
                                onChange={(e) => setUsername(e.target.value)}
                                className="form-control"
                                placeholder="user@foodstore.in"
                                required
                            />
                        </div>

                        <div className="form-group">
                            <label>Password</label>
                            <input
                                type="password"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                className="form-control"
                                placeholder="********"
                                required
                            />
                        </div>

                        <button type="submit" className="btn btn-danger" style={{ width: '100%', marginTop: '1rem', padding: '0.75rem' }}>Submit</button>
                    </form>

                    <p style={{ textAlign: 'center', marginTop: '1.5rem', fontSize: '0.9rem' }}>
                        Don't Have Account? <Link to="/register" style={{ color: '#0d6efd', textDecoration: 'none', fontWeight: '500' }}>Create Account</Link>
                    </p>
                </div>
            </div>
        </div>
    );
};
