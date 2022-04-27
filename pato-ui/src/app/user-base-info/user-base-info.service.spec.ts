import { TestBed } from '@angular/core/testing';

import { UserBaseInfoService } from './user-base-info.service';

describe('UserBaseInfoService', () => {
  let service: UserBaseInfoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserBaseInfoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
