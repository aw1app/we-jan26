import { useState } from "react";
import { createContext } from "react";


export const ProductContext = createContext();

const productsArr = [
  { id: 1, name: "HP Monitor", price: 50000 },
  { id: 2, name: "Dell Laptop", price: 85000 },
  { id: 3, name: "Mouse", price: 1500 }
];

export const ProductProvider = ({ children }) => {

  const [products, setProducts] = useState(productsArr);


  const addProduct = (name, price) => {

    const newProduct = {
      id: Date.now(),
      name,
      price
    };

    setProducts(prev => [...prev, newProduct]);
  };


  return (

    <ProductContext.Provider value={{ products, addProduct }} > {children} </ProductContext.Provider>

  )


}

