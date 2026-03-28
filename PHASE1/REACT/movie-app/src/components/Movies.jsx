import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchMovies, setQuery } from "../slices/movieSlice";
import SearchBar from "./SearchBar";
import MovieCard from "./MovieCard";

export default function Movies() {
  const dispatch = useDispatch();

  const { items, filtered, status, error, query } = useSelector(
    (state) => state.movies
  );

  useEffect(() => {
    dispatch(fetchMovies({ query }));
  }, [dispatch]);

  const handleSearch = (val) => {
    dispatch(setQuery(val));
  };

  if (status === "loading") return <p className="status">Loading movies...</p>;
  if (status === "failed") return <p className="error">{error}</p>;

  return (
    <div className="container">
      <h2>Movies</h2>

      <SearchBar value={query} onChange={handleSearch} />

      <p className="results-count">
        Showing <span>{filtered.length}</span> of {items.length} movies
      </p>

      <div className="movies-grid">
        {filtered.map((m) => (
          <MovieCard key={m.id} movie={m} />
        ))}
      </div>
    </div>
  );
}