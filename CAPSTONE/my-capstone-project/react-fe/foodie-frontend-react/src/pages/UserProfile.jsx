import React, { useState, useEffect, useContext } from 'react';
import { AuthContext } from '../context/AuthContext';

export const UserProfile = () => {
    const { currentUser, updateProfile } = useContext(AuthContext);
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [contact, setContact] = useState('');
    const [address, setAddress] = useState('');
    const [message, setMessage] = useState('');

    useEffect(() => {
        if (currentUser) {
            setName(currentUser.name || '');
            setEmail(currentUser.email || '');
            setContact(currentUser.contact || '');
            setAddress(currentUser.address || '');
        }
    }, [currentUser]);

    const handleSubmit = async (e) => {
        e.preventDefault();
        const updated = {
            username: currentUser ? currentUser.username : 'user1',
            name,
            email,
            contact,
            address
        };

        await updateProfile(updated);
        setMessage('Profile updated successfully!');
        setTimeout(() => setMessage(''), 3000);
    };

    return (
        <div className="container">
            <div style={{ display: 'flex', gap: '2rem', flexWrap: 'wrap' }}>
                <div style={{ flex: 2, minWidth: '300px' }} className="card">
                    <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '1rem' }}>
                        <h3>My Address</h3>
                        <button className="btn btn-primary btn-sm">+ Add New Address</button>
                    </div>

                    <div style={{ background: '#f8f9fa', padding: '1rem', borderRadius: '6px', marginBottom: '1rem', border: '1px solid #e9ecef' }}>
                        <p style={{ color: '#666', fontSize: '0.85rem' }}>Address</p>
                        <p style={{ fontWeight: '600', marginBottom: '0.5rem' }}>{address || '92795 Hugh Park, Carrollfort, Bilzen'}</p>
                        <div style={{ display: 'flex', justifyContent: 'flex-end', gap: '0.5rem' }}>
                            <button className="btn btn-sm btn-secondary">Update</button>
                            <button className="btn btn-sm btn-danger">Remove</button>
                        </div>
                    </div>
                </div>

                <div style={{ flex: 1, minWidth: '280px' }} className="card">
                    <div style={{ textAlign: 'center', marginBottom: '1.5rem' }}>
                        <div style={{ width: '80px', height: '80px', background: '#dc3545', color: 'white', borderRadius: '50%', display: 'flex', alignItems: 'center', justifyContent: 'center', fontSize: '2.2rem', margin: '0 auto 0.5rem' }}>
                            <i className="fa fa-user"></i>
                        </div>
                    </div>

                    {message && <div className="alert alert-success">{message}</div>}

                    <form onSubmit={handleSubmit}>
                        <div className="form-group">
                            <label>Full Name</label>
                            <input type="text" value={name} onChange={(e) => setName(e.target.value)} className="form-control" />
                        </div>

                        <div className="form-group">
                            <label>Email address</label>
                            <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} className="form-control" />
                        </div>

                        <div className="form-group">
                            <label>Phone Number</label>
                            <input type="text" value={contact} onChange={(e) => setContact(e.target.value)} className="form-control" />
                        </div>

                        <button type="submit" className="btn btn-primary" style={{ width: '100%', marginTop: '1rem' }}>Update Profile</button>
                    </form>
                </div>
            </div>
        </div>
    );
};
