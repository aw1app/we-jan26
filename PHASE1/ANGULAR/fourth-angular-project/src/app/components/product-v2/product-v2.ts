import { Component, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../../models/product';
import { ProductServiceV2 } from '../../services/product-v2';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'product-v2',
  imports: [CommonModule],
  templateUrl: './product-v2.html',
  styleUrl: './product-v2.css',
})
export class ProductComponentV2 {

  product$!: Observable<Product | undefined>;
  id!: number;

  constructor(private route: ActivatedRoute, private productService: ProductServiceV2) {
  }

  ngOnInit(): void {
    this.productService.loadProducts();

    this.id = Number(this.route.snapshot.paramMap.get('id'));

    this.product$ = this.productService.getProduct(this.id);
  }


}
