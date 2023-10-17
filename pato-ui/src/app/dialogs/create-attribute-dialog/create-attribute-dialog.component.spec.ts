import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAttributeDialogComponent } from './create-attribute-dialog.component';

describe('CreateAttributeDialogComponent', () => {
  let component: CreateAttributeDialogComponent;
  let fixture: ComponentFixture<CreateAttributeDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateAttributeDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateAttributeDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
