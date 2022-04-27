import { TestBed } from '@angular/core/testing';

import { UsersOverviewRestService } from './users-overview-rest.service';

describe('UsersOverviewRestService', () => {
  let service: UsersOverviewRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsersOverviewRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
