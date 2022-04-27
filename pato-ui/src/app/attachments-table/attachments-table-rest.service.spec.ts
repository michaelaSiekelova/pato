import { TestBed } from '@angular/core/testing';

import { AttachmentsTableRestService } from './attachments-table-rest.service';

describe('AttachmentsTableRestService', () => {
  let service: AttachmentsTableRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AttachmentsTableRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
