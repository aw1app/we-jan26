import './App.css'
import ProductF from './components/product/ProductF'
import ProductC from './components/product/ProductC'

function App() {


  return (
    <>
      <h1> Welcome to E Store</h1>
      <ProductF name="Dell Monitor" price="2000" />
      <ProductF name="HP Monitor" price="2040" />
      <ProductC name="Samsung Phone" price="6000" />
      <ProductC name="IPad" price="2600" />
    </>
  )
}

export default App
