import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ProductListComponent } from './components/product-list/product-list';
import { ProductComponent } from './components/product/product';
import { AddProductComponent } from './components/add-product/add-product';
import { ProductListV2 } from './components/product-list-v2/product-list-v2';
import { ProductComponentV2 } from './components/product-v2/product-v2';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [CommonModule, RouterOutlet, ProductListComponent, ProductComponent,AddProductComponent,
     ProductListV2, ProductComponentV2],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

  status = 'approved';

}
