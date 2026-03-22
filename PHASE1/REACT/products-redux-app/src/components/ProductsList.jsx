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

            {
            items.map((p) => (
                <div key={p.id} style={{ border: '1px solid gray', margin: '2px', padding: '1px' }}>
                    <h4>{p.name}, Price: {p.price}</h4>
                </div>
            ))}

        </>
    );



}

export default ProductsList;