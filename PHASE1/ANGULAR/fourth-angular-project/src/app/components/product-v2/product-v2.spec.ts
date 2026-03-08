import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductV2 } from './product-v2';

describe('ProductV2', () => {
  let component: ProductV2;
  let fixture: ComponentFixture<ProductV2>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProductV2]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductV2);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
