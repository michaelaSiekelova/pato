import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PermisionsTableComponent } from './permisions-table.component';

describe('PermisionsTableComponent', () => {
  let component: PermisionsTableComponent;
  let fixture: ComponentFixture<PermisionsTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PermisionsTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PermisionsTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
