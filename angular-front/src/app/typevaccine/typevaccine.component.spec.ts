import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TypevaccineComponent } from './typevaccine.component';

describe('TypevaccineComponent', () => {
  let component: TypevaccineComponent;
  let fixture: ComponentFixture<TypevaccineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TypevaccineComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TypevaccineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
