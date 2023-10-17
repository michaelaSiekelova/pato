import { TestBed } from '@angular/core/testing';

import { TicketDetailRestService } from './ticket-detail-rest.service';

describe('TicketDetailRestService', () => {
  let service: TicketDetailRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TicketDetailRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
