import { TestBed } from '@angular/core/testing';

import { CreateTicketDialogRestService } from './create-ticket-dialog-rest.service';

describe('CreateTicketDialogRestService', () => {
  let service: CreateTicketDialogRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateTicketDialogRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
