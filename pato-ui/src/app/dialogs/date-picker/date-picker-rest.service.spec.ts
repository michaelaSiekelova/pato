import { TestBed } from '@angular/core/testing';

import { DatePickerRestService } from './date-picker-rest.service';

describe('DatePickerRestService', () => {
  let service: DatePickerRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DatePickerRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
