import { useState } from 'react';
import {AuthProvider} from "./context/AuthContext.jsx";
import {CartProvider} from "./context/CartContext.jsx";
import {Navigate, Route, Router, Routes} from "react-router-dom";
import {Navbar} from "./components/Navbar.jsx";
import {Login} from "./pages/Login.jsx";
import {Register} from "./pages/Register.jsx";
import {Restaurants} from "./pages/Restaurants.jsx";
import {Dishes} from "./pages/Dishes.jsx";
import {Cart} from "./pages/Cart.jsx";
import {Checkout} from "./pages/Checkout.jsx";
import {Orders} from "./pages/Orders.jsx";
import {UserProfile} from "./pages/UserProfile.jsx";

function App() {
  return (
      <AuthProvider>
        <CartProvider>
          <Router>
            <Navbar />
            <Routes>
              <Route path="/" element={<Navigate to="/restaurants" replace />} />
              <Route path="/login" element={<Login />} />
              <Route path="/register" element={<Register />} />
              <Route path="/restaurants" element={<Restaurants />} />
              <Route path="/restaurants/:restaurantId/dishes" element={<Dishes />} />
              <Route path="/cart" element={<Cart />} />
              <Route path="/checkout" element={<Checkout />} />
              <Route path="/my-orders" element={<Orders />} />
              <Route path="/profile" element={<UserProfile />} />
              <Route path="*" element={<Navigate to="/restaurants" replace />} />
            </Routes>
          </Router>
        </CartProvider>
      </AuthProvider>
  );
}

export default App;
