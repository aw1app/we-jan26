import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

const API_URL = 'http://localhost:3000/movies';

//FETCH MOVIES

export const fetchMovies = createAsyncThunk(
    'movies/fetchMovies',
    async ({ query }) => {

        const params = {};
        if (query) params.title_like = query; // JSON server

        try {
            const response = await axios.get(API_URL, { params });
            return response.data;
        }
        catch (err) {
            console.log(err.message);
            return rejectWithValue(err.message);
        }
    }
);



const moviesSlice = createSlice(

    {
        name: 'movies',

        initialState: {
            items: [],
            filtered: [],
            status: 'idle',
            error: null,
            query: '',
            genre: 'All',
        },

        reducers: {
            setQuery: (state, action) => {
                state.query = action.payload
                applyFilter(state);
            },
        },

        extraReducers: (builder) => {
            builder
                // Cases
                // Fetching Movies
                .addCase(fetchMovies.pending, state => {
                    state.status = 'loading';
                    state.error = null
                })
                .addCase(fetchMovies.fulfilled, (state, action) => {
                    state.status = 'succeeded'
                    state.items = action.payload
                    applyFilter(state)
                })
                .addCase(fetchMovies.rejected, (state, action) => {
                    state.status = 'failed'
                    state.error = action.payload
                })

        },
    }

);

// helper — runs on items in state
function applyFilter(state) {
    let result = state.items;

    if (state.query)
        result = result.filter(m => m.title.toLowerCase().includes(state.query.toLowerCase()))

    state.filtered = result
}

export const { setQuery } = moviesSlice.actions;
export default moviesSlice.reducer;