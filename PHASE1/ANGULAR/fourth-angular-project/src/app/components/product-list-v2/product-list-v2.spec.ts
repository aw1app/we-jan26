import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductListV2 } from './product-list-v2';

describe('ProductListV2', () => {
  let component: ProductListV2;
  let fixture: ComponentFixture<ProductListV2>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProductListV2]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductListV2);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
