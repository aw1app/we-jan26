import { Routes, Route } from 'react-router-dom';
import MoviesList from './components/Movies';
import MovieDetail from './components/MovieDetail';
import './App.css';

function App() {
  return (
    <div className="container">
      <h1>The NetFLIX Movie App</h1>

      <Routes>
        <Route path="/" element={<MoviesList />} />
        <Route path="/movies/:id" element={<MovieDetail />} />
      </Routes>
    </div>
  );
}

export default App;