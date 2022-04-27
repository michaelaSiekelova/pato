import { TestBed } from '@angular/core/testing';

import { PermisionsTableRestService } from './permisions-table-rest.service';

describe('PermisionsTableRestService', () => {
  let service: PermisionsTableRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PermisionsTableRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
