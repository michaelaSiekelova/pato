import { TestBed } from '@angular/core/testing';

import { CreateAttributeValueDialogRestService } from './create-attribute-value-dialog-rest.service';

describe('CreateAttributeValueDialogRestService', () => {
  let service: CreateAttributeValueDialogRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateAttributeValueDialogRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
