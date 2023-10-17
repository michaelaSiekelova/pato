import { TestBed } from '@angular/core/testing';

import { CreateAttributeDialogRestService } from './create-attribute-dialog-rest.service';

describe('CreateAttributeDialogRestService', () => {
  let service: CreateAttributeDialogRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateAttributeDialogRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
