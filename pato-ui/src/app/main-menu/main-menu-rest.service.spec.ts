import { TestBed } from '@angular/core/testing';

import { MainMenuRestService } from './main-menu-rest.service';

describe('MainMenuRestService', () => {
  let service: MainMenuRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MainMenuRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
