import { useState } from 'react'
import './App.css'
import ProductsList from './components/ProductsList'
import AddProduct from './components/AddProduct'
import { Link, Route, Routes } from 'react-router-dom'

function App() {

  return (
    <>
      <div className="container">
        <nav className="navbar">
          <h2>Products App</h2>
          <div>
            <Link to="/">Products</Link>
            <Link to="/add">Add Product</Link>
          </div>
        </nav>

        <Routes>
          <Route path="/" element={<ProductsList />} />
          <Route path="/add" element={<AddProduct />} />
        </Routes>
      </div>
    </>
  )
}

export default App
