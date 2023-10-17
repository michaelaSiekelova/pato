import { TestBed } from '@angular/core/testing';

import { TicketsTableRestService } from './tickets-table-rest.service';

describe('TicketsTableRestService', () => {
  let service: TicketsTableRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TicketsTableRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
