import { useState } from 'react'
import './App.css'
import ProductsList from './components/ProductsList'
import AddProduct from './components/AddProduct'
import { Link, Route, Routes } from 'react-router-dom'

function App() {

  return (
    <>
      {/* Navigation */}
      <nav>
        <Link to="/">Products</Link> |{" "}
        <Link to="/add">Add Product</Link>
      </nav>
      <hr />

      {/* Routes */}
      <Routes>
        <Route path="/" element={<ProductsList />} />
        <Route path="/add" element={<AddProduct />} />
      </Routes>

    </>
  )
}

export default App
