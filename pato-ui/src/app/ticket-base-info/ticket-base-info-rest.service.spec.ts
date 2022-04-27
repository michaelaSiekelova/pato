import { TestBed } from '@angular/core/testing';

import { TicketBaseInfoRestService } from './ticket-base-info-rest.service';

describe('TicketBaseInfoRestService', () => {
  let service: TicketBaseInfoRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TicketBaseInfoRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
