import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchMovies } from "../slices/movieSlice";

export default function Movies() {

    const dispatch = useDispatch();

    const { items, filtered, status, error, query, genre } = useSelector(state => state.movies)

    // Initial fetch on mount
    useEffect(() => {
        dispatch(fetchMovies())
    }, [dispatch])



    if (status === 'loading') return <p className="status">Loading products...</p>;
    if (status === 'failed') return <p className="error">Error: {error}</p>;


    return (
        <div className="container">
            <h2>Movies</h2>

            <div>
                {items.map((p) => (
                    <div key={p.id} >
                        <h3>{p.title}</h3>
                    </div>
                ))}
            </div>
        </div>
    );





}