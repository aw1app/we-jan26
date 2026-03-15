import './App.css'
import ProductF from './components/product/ProductF'
import ProductC from './components/product/ProductC'
import Timer from './components/timer/Timer'
import Products from './components/products/products'


 const productsArr = [
    { id:1, name:"HP Monitor", price:50000 },
    { id:2, name:"Dell Laptop", price:85000 },
    { id:3, name:"Mouse", price:1500 }
  ];

function App() {

  function func1(){
    console.log("Inside App.jsx's func1 function");
  }

  return (
    <>
      <h1> Welcome to E Store</h1>
      <Timer />

      <Products products={productsArr} />

      <ProductF name="Dell Monitor" price="2000" f1={func1}/>
      <ProductF name="HP Monitor" price="2040" />
      <ProductC name="Samsung Phone" price="6000" />
      <ProductC name="IPad" price="2600" />
    </>
  )
}

export default App
