import { Routes } from '@angular/router';
import { ProductListV2 } from './components/product-list-v2/product-list-v2';
import { ProductComponentV2 } from './components/product-v2/product-v2';

export const routes: Routes = [

    { path:'products' , component: ProductListV2 },
    { path:'product/1' , component: ProductComponentV2},
];
