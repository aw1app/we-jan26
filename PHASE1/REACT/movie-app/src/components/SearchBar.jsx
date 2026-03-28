import { useState } from "react";
import { useDispatch } from "react-redux";
import { fetchMovies, setQuery } from "../slices/movieSlice";



export default function SearchBar() {

    const [value, setValue] = useState('');

    const dispatch = useDispatch();

    const handleChange = (e) => {
        const val = e.target.value
        setValue(val)
        dispatch(setQuery(val)) // client-side filter
    }


    // Search button → re-fetch from JSON Server with params
    const handleSearch = () => {
        dispatch(fetchMovies({ query: value }))
    }

    // Also trigger fetch on Enter key — event handling
    const handleKeyDown = (e) => {
        if (e.key === 'Enter') handleSearch()
    }




    return (
        <div className="search-row">
            <input
                type="text"
                className="search-input"
                placeholder="Search movies..."
                value={value} 
                onChange={handleChange} 
                onKeyDown={handleKeyDown}
            />
            <button
                className="search-btn"
                onClick={handleSearch}>
                🔍 Search
            </button>
        </div>
    )


}