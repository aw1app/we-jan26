import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NoSuchComponent } from './no-such-component';

describe('NoSuchComponent', () => {
  let component: NoSuchComponent;
  let fixture: ComponentFixture<NoSuchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NoSuchComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NoSuchComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
