import { Component, signal } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { ProductListV2 } from './components/product-list-v2/product-list-v2';
import { ProductComponentV2 } from './components/product-v2/product-v2';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [CommonModule, RouterOutlet, RouterLink,  ProductListV2, ProductComponentV2],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {


}
