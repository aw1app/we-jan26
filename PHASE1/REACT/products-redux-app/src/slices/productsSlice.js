
import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

const API_URL = 'http://localhost:3000/products';

//FETCH PRODUCTS

export const fetchProducts = createAsyncThunk(
    'products/fetchProducts',
    async () => {
        const response = await axios.get(API_URL);
        return response.data;
    }
);



//ADD PRODUCT








// Create the slice
const productsSlice = createSlice(

    {
        name: 'products',

        initialState: {
            items: [],
            loading: false,
            error: null,
        },

        reducers: {},

        extraReducers: (builder) => {

            builder
                .addCase(fetchProducts.pending, (state) => {
                    state.loading = true;
                })
                .addCase(fetchProducts.fulfilled, (state, action) => {
                    state.loading = false;
                    state.items = action.payload;
                })
                .addCase(fetchProducts.rejected, (state, action) => {
                    state.loading = false;
                    state.error = action.error.message;
                })


        }

    }

);


export default productsSlice.reducer;