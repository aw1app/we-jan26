
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
export const addProduct = createAsyncThunk(
    'products/addProduct',
    async (product) => {
        const response = await axios.post(API_URL, product);
        return response.data;
    }
);







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
                // FETCH PRODUCTS
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

                // ADD PRODUCT
                .addCase(addProduct.fulfilled, (state, action) => {
                    let createProduct = action.payload;
                    state.items.push(createProduct);
                })


        }

    }

);


export default productsSlice.reducer;