import { useNavigate } from 'react-router-dom';


export default function MovieCard ({ movie }) {
    const navigate = useNavigate()
    return (
        <div className="movie-card"
            onClick={() => navigate(`/movies/${movie.id}`)}>
            <div className="movie-poster"
                style={{ background: movie.color }}>
                {movie.emoji}
                <span className="rating-badge">⭐ {movie.rating}</span>
            </div>
            <div className="movie-body">
                <h3 className="movie-title">{movie.title}</h3>
                <div className="movie-meta">
                    <span className="genre-tag">{movie.genre}</span>
                    <span className="movie-year">{movie.year}</span>
                </div>
                <p className="movie-desc">{movie.description}</p>
            </div>
        </div>
    )


}