import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AttributeValuesTableComponent } from './attribute-values-table.component';

describe('AttributeValuesTableComponent', () => {
  let component: AttributeValuesTableComponent;
  let fixture: ComponentFixture<AttributeValuesTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AttributeValuesTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AttributeValuesTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
