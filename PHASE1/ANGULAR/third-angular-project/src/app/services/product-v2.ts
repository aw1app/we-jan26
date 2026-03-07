import { Injectable } from '@angular/core';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { Product } from '../models/product';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ProductServiceV2 {

  private productsSubject = new BehaviorSubject<Product[]>([]);

  products$ = this.productsSubject.asObservable();

  // web service providing products data
  private apiUrl = 'http://localhost:3000/products';

  constructor(private http: HttpClient) { }

  loadProducts(): void {

    this.http.get<Product[]>(this.apiUrl).subscribe({
      next: (data) => {
        console.log('HTTP products:', data);
        this.productsSubject.next(data); // 
      },
      error: (err) => console.error(err)
    });

  }

  getProducts(): Observable<Product[]> {
    return this.products$;
  }

  getProduct(id: number): Observable<Product | undefined> {

   let prod :  Observable<Product | undefined>  = this.products$.pipe(
      map(products => products.find(p => Number(p.id) === id))
    );

    return prod;
  }


}
