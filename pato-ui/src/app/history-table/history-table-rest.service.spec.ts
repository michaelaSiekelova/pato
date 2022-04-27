import { TestBed } from '@angular/core/testing';

import { HistoryTableRestService } from './history-table-rest.service';

describe('HistoryTableRestService', () => {
  let service: HistoryTableRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HistoryTableRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
