import { TestBed } from '@angular/core/testing';

import { TicketsOverviewRestService } from './tickets-overview-rest.service';

describe('TicketsOverviewRestService', () => {
  let service: TicketsOverviewRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TicketsOverviewRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
