import { useState } from 'react'
import './App.css'
import { useContext } from 'react'
import { ProductContext } from './contexts/ProductContext'
import Products from './components/products/Products';
import AddProduct from './components/AddProduct/AddProduct';


function App() {

  
  

  return (
    <>
    <h3> List of products </h3>
    <Products  />

    <AddProduct /> 

     
    </>
  )
}

export default App;
