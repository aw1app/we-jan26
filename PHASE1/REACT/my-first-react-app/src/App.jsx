import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Product from './components/product/Product'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
     <h1> Welcome to E Store</h1>
     <Product name="Dell Monitor" price="2000" />
    <Product name="HP Monitor" price="2040" />
    <Product name="Samsung Phone" price="6000" />
    <Product name="IPad" price="2600" />
    </>
  )
}

export default App
