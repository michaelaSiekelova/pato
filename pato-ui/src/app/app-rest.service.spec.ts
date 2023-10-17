import { TestBed } from '@angular/core/testing';

import { AppRestService } from './app-rest.service';

describe('AppRestService', () => {
  let service: AppRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AppRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
