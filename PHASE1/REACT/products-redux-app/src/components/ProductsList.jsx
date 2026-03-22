import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchProducts } from "../slices/productsSlice";


function ProductsList() {

    const { items, loading, error } = useSelector(state => state.products);
    const dispatch = useDispatch();


    useEffect(
        () => {
            dispatch(fetchProducts());
        },
        [dispatch]
    );


    if (loading) return <p className="status">Loading products...</p>;
    if (error) return <p className="error">Error: {error}</p>;


    return (
        <div className="container">
            <h2>Products</h2>

            <div className="products-grid">
                {items.map((p) => (
                    <div key={p.id} className="product-card">
                        <h3>{p.name}</h3>
                        <p className="price">₹ {p.price}</p>
                        <p className="desc">{p.description || "No description"}</p>
                    </div>
                ))}
            </div>
        </div>
    );



}

export default ProductsList;