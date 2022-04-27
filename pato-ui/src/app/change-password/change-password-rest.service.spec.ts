import { TestBed } from '@angular/core/testing';

import { ChangePasswordRestService } from './change-password-rest.service';

describe('ChangePasswordRestService', () => {
  let service: ChangePasswordRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChangePasswordRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
