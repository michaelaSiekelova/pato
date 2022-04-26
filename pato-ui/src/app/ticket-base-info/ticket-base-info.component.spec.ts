import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketBaseInfoComponent } from './ticket-base-info.component';

describe('TicketBaseInfoComponent', () => {
  let component: TicketBaseInfoComponent;
  let fixture: ComponentFixture<TicketBaseInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TicketBaseInfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TicketBaseInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
