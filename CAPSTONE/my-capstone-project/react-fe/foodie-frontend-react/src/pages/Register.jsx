import React, { useState, useContext } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { AuthContext } from '../context/AuthContext';

export const Register = () => {
    const [name, setName] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState('');

    const { register } = useContext(AuthContext);
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        const userData = { username, name, password, email: `${username}@foodstore.in` };
        const res = await register(userData);
        if (res.registered) {
            navigate('/login');
        } else {
            setErrorMessage(res.error || 'Registration failed');
        }
    };

    return (
        <div style={{ display: 'flex', minHeight: '85vh', background: '#fff' }}>
            <div style={{ flex: 1, background: '#b01c2e', color: 'white', display: 'flex', flexDirection: 'column', justifyContent: 'center', padding: '4rem' }}>
                <h1 style={{ fontSize: '2.8rem', fontWeight: '700', marginBottom: '1rem' }}>FOODIE INC</h1>
                <p style={{ fontSize: '1.2rem', opacity: '0.9' }}>Join Foodie Delivery Services Online Today</p>
            </div>

            <div style={{ flex: 1, display: 'flex', alignItems: 'center', justifyContent: 'center', padding: '2rem' }}>
                <div style={{ width: '100%', maxWidth: '400px' }} className="card">
                    <h2 style={{ textAlign: 'center', marginBottom: '1.5rem', fontWeight: '600' }}>Register</h2>

                    {errorMessage && <div className="alert alert-danger">{errorMessage}</div>}

                    <form onSubmit={handleSubmit}>
                        <div className="form-group">
                            <label>Name</label>
                            <input
                                type="text"
                                value={name}
                                onChange={(e) => setName(e.target.value)}
                                className="form-control"
                                placeholder="eg: John Peterson"
                                required
                            />
                        </div>

                        <div className="form-group">
                            <label>Email / Username</label>
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

                        <button type="submit" className="btn btn-danger" style={{ width: '100%', marginTop: '1rem', padding: '0.75rem' }}>Sign Up</button>
                    </form>

                    <p style={{ textAlign: 'center', marginTop: '1.5rem', fontSize: '0.9rem' }}>
                        Already Have Account? <Link to="/login" style={{ color: '#0d6efd', textDecoration: 'none', fontWeight: '500' }}>Sign In</Link>
                    </p>
                </div>
            </div>
        </div>
    );
};
