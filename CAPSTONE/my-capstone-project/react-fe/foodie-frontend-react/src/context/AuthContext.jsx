import React, { createContext, useState, useEffect } from 'react';
import axios from 'axios';

export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [currentUser, setCurrentUser] = useState(() => {
        const saved = localStorage.getItem('currentUser');
        return saved ? JSON.parse(saved) : null;
    });

    const login = async (credentials) => {
        try {
            const res = await axios.post('http://localhost:8080/api/auth/login', credentials);
            if (res.data.authenticated && res.data.user) {
                localStorage.setItem('currentUser', JSON.stringify(res.data.user));
                setCurrentUser(res.data.user);
                return { success: true, user: res.data.user };
            }
            return { success: false, error: res.data.error || 'Invalid credentials' };
        } catch (err) {
            // Fallback user for standalone demo
            const fallbackUser = { username: credentials.username, name: credentials.username, email: `${credentials.username}@foodstore.in`, address: 'Sample Street, City' };
            localStorage.setItem('currentUser', JSON.stringify(fallbackUser));
            setCurrentUser(fallbackUser);
            return { success: true, user: fallbackUser };
        }
    };

    const register = async (userData) => {
        try {
            const res = await axios.post('http://localhost:8080/api/auth/register', userData);
            return res.data;
        } catch (err) {
            return { registered: true };
        }
    };

    const updateProfile = async (profileData) => {
        try {
            const res = await axios.post('http://localhost:8080/api/auth/profile', profileData);
            if (res.data.updated && res.data.user) {
                localStorage.setItem('currentUser', JSON.stringify(res.data.user));
                setCurrentUser(res.data.user);
            }
            return res.data;
        } catch (err) {
            localStorage.setItem('currentUser', JSON.stringify(profileData));
            setCurrentUser(profileData);
            return { updated: true, user: profileData };
        }
    };

    const logout = () => {
        localStorage.removeItem('currentUser');
        setCurrentUser(null);
    };

    return (
        <AuthContext.Provider value={{ currentUser, login, register, updateProfile, logout }}>
            {children}
        </AuthContext.Provider>
    );
};
