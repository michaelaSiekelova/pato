import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateDescriptionDialogComponent } from './update-description-dialog.component';

describe('UpdateDescriptionDialogComponent', () => {
  let component: UpdateDescriptionDialogComponent;
  let fixture: ComponentFixture<UpdateDescriptionDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateDescriptionDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateDescriptionDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
