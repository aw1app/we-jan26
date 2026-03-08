import { TestBed } from '@angular/core/testing';

import { ProductV2 } from './product-v2';

describe('ProductV2', () => {
  let service: ProductV2;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductV2);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
