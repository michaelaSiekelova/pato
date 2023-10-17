import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChooseUserDialogComponent } from './choose-user-dialog.component';

describe('ChooseUserDialogComponent', () => {
  let component: ChooseUserDialogComponent;
  let fixture: ComponentFixture<ChooseUserDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChooseUserDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChooseUserDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
