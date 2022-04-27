import { TestBed } from '@angular/core/testing';

import { AttributeValuesTableRestService } from './attribute-values-table-rest.service';

describe('AttributeValuesTableRestService', () => {
  let service: AttributeValuesTableRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AttributeValuesTableRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
