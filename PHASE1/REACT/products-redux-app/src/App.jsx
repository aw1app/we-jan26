import { useState } from 'react'
import './App.css'
import ProductsList from './components/ProductsList'
import AddProduct from './components/AddProduct'

function App() {

  return (
    <>
    <AddProduct />
     <ProductsList />
    </>
  )
}

export default App
