import { useState } from 'react'
import './App.css'
import { useContext } from 'react'
import { ProductContext } from './contexts/ProductContext'
import Products from './components/products/Products';


function App() {

  
  

  return (
    <>
    <h3> List of products </h3>
    <Products  />

     
    </>
  )
}

export default App;
