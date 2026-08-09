import React, { createContext, useState, useEffect, useContext } from 'react';
import axios from 'axios';
import { AuthContext } from './AuthContext';

export const CartContext = createContext();

export const CartProvider = ({ children }) => {
    const { currentUser } = useContext(AuthContext);
    const [cartItems, setCartItems] = useState([]);

    const userId = currentUser ? currentUser.username : 'guest';

    const fetchCart = async () => {
        try {
            const res = await axios.get(`http://localhost:8080/api/cart/user/${userId}`);
            setCartItems(res.data);
        } catch (err) {
            // Fallback
        }
    };

    useEffect(() => {
        fetchCart();
    }, [currentUser]);

    const addToCart = async (dish) => {
        const item = {
            userId: userId,
            dishId: dish.id,
            dishName: dish.name,
            price: dish.price,
            quantity: 1,
            thumbnailImage: dish.thumbnailImage || 'default.jpg'
        };

        try {
            await axios.post('http://localhost:8080/api/cart/add', item);
            fetchCart();
        } catch (err) {
            // Fallback local update
            setCartItems(prev => {
                const existing = prev.find(i => i.dishId === dish.id);
                if (existing) {
                    return prev.map(i => i.dishId === dish.id ? { ...i, quantity: i.quantity + 1 } : i);
                }
                return [...prev, { cartId: Date.now(), ...item }];
            });
        }
    };

    const updateQuantity = async (item, delta) => {
        const newQty = item.quantity + delta;
        if (newQty <= 0) {
            return removeItem(item);
        }

        try {
            await axios.put('http://localhost:8080/api/cart/update', { ...item, quantity: newQty });
            fetchCart();
        } catch (err) {
            setCartItems(prev => prev.map(i => i.cartId === item.cartId ? { ...i, quantity: newQty } : i));
        }
    };

    const removeItem = async (item) => {
        try {
            if (item.cartId) {
                await axios.delete(`http://localhost:8080/api/cart/delete/${item.cartId}`);
            }
            fetchCart();
        } catch (err) {
            setCartItems(prev => prev.filter(i => i.cartId !== item.cartId));
        }
    };

    const clearCart = async () => {
        try {
            await axios.delete(`http://localhost:8080/api/cart/clear/${userId}`);
            setCartItems([]);
        } catch (err) {
            setCartItems([]);
        }
    };

    const cartCount = cartItems.reduce((sum, item) => sum + item.quantity, 0);

    return (
        <CartContext.Provider value={{ cartItems, cartCount, addToCart, updateQuantity, removeItem, clearCart, fetchCart }}>
            {children}
        </CartContext.Provider>
    );
};
