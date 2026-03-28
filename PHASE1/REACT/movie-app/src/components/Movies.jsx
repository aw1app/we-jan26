import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchMovies } from "../slices/movieSlice";
import SearchBar from "./SearchBar";

export default function Movies() {

    const dispatch = useDispatch();

    const { items, filtered, status, error, query, genre } = useSelector(state => state.movies)

    // Initial fetch on mount
    useEffect(() => {
        dispatch(fetchMovies({ query }))
    }, [dispatch])


    const handleSearch = (val) => {
        dispatch(setQuery(val))
    }

    if (status === 'loading') return <p className="status">Loading products...</p>;
    if (status === 'failed') return <p className="error">Error: {error}</p>;


    return (
        <div className="container">

            <h2>Movies</h2>
            <SearchBar value={query} onChange={handleSearch} />
            <div>
                {filtered && filtered.map((m) => (
                    <div key={m.id} >
                        <h3>{m.title} (rating : {m.rating}) </h3>,
                    </div>
                ))}
            </div>
        </div>
    );





}