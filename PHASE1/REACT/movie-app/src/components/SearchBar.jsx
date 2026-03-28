import { useState } from "react";

export default function SearchBar({ value, onChange }) {
  const [input, setInput] = useState(value || "");

  const handleSubmit = (e) => {
    e.preventDefault();
    onChange(input);
  };

  return (
    <form className="search-row" onSubmit={handleSubmit}>
      <input
        type="text"
        className="search-input"
        placeholder="Search movies..."
        value={input}
        onChange={(e) => setInput(e.target.value)}
      />

      <button type="submit" className="search-btn">
        🔍 Search
      </button>
    </form>
  );
}