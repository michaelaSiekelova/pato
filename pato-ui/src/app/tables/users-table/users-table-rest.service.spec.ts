import { TestBed } from '@angular/core/testing';

import { UsersTableRestService } from './users-table-rest.service';

describe('UsersTableRestService', () => {
  let service: UsersTableRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsersTableRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
