import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

const API_URL = 'http://localhost:3000/movies';

//FETCH MOVIES

export const fetchMovies = createAsyncThunk(
    'movies/fetchMovies',
    async () => {
        const response = await axios.get(API_URL);
        return response.data;
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

        reducers: {},

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
                    // applyFilter(state)
                })
                .addCase(fetchMovies.rejected, (state, action) => {
                    state.status = 'failed'
                    state.error = action.payload
                })

        },
    }

);


export default moviesSlice.reducer;