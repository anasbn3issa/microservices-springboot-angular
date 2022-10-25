import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SterilizationComponent } from './sterilization.component';

describe('SterilizationComponent', () => {
  let component: SterilizationComponent;
  let fixture: ComponentFixture<SterilizationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SterilizationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SterilizationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
