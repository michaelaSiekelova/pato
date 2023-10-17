import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAttributeValueDialogComponent } from './create-attribute-value-dialog.component';

describe('CreateAttributeValueDialogComponent', () => {
  let component: CreateAttributeValueDialogComponent;
  let fixture: ComponentFixture<CreateAttributeValueDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateAttributeValueDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateAttributeValueDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
