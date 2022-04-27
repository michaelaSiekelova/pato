import { TestBed } from '@angular/core/testing';

import { AttributesTableRestService } from './attributes-table-rest.service';

describe('AttributesTableRestService', () => {
  let service: AttributesTableRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AttributesTableRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
