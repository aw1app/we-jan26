import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../../models/product';
import { ProductServiceV2 } from '../../services/product-v2';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'product-list-v2',
  imports: [CommonModule],
  templateUrl: './product-list-v2.html',
  styleUrl: './product-list-v2.css',
})
export class ProductListV2 {

 products$!: Observable<Product[]>;
  
    constructor(private productService: ProductServiceV2) {
    }
  
    ngOnInit(): void {
      this.productService.loadProducts();
      this.products$ = this.productService.getProducts();
    }

}
