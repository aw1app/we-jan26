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


    if (loading) return <h3>Loading...</h3>;

    if (error) return <h3>Error: {error}</h3>;


    return (
        <>
            <h2>Product List</h2>

            {items.map((p) => (
                <div key={p.id} style={{ border: '1px solid gray', margin: '10px', padding: '10px' }}>
                    <h4>{p.name}</h4>
                    <p>Price: {p.price}</p>
                </div>
            ))}

        </>
    );



}

export default ProductsList;