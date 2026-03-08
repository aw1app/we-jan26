import { Routes } from '@angular/router';
import { ProductListV2 } from './components/product-list-v2/product-list-v2';
import { ProductComponentV2 } from './components/product-v2/product-v2';
import { NoSuchComponent } from './components/no-such-component/no-such-component';

export const routes: Routes = [

    { path: 'products', component: ProductListV2 },
    { path: 'product/:id', component: ProductComponentV2 },
    // { path:'user-profile' , component: UserComponent},
    { path: '**', component: NoSuchComponent },

];
