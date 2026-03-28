import { useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import { fetchMovieById } from "../slices/movieSlice";

export default function MovieDetail() {
  const { id } = useParams();
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const { selectedMovie: movie, status, error } = useSelector(
    (state) => state.movies
  );

  useEffect(() => {
    dispatch(fetchMovieById(id));
  }, [dispatch, id]);

  if (status === "loading") return <p>Loading...</p>;
  if (status === "failed") return <p className="error">{error}</p>;
  if (!movie) return null;

  return (
    <div className="container">
      <div className="detail-card">
        <button className="back" onClick={() => navigate(-1)}>
          ← Back
        </button>

        <div
          className="detail-hero"
          style={{ background: movie.color }}
        >
          {movie.emoji}
        </div>

        <div className="detail-body">
          <h2 className="detail-title">{movie.title}</h2>

          <div className="detail-tags">
            <span>{movie.genre}</span>
            <span>{movie.year}</span>
            <span>⭐ {movie.rating}</span>
          </div>

          <p className="detail-desc">{movie.description}</p>
        </div>
      </div>
    </div>
  );
}