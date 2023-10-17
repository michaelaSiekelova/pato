import { TestBed } from '@angular/core/testing';

import { UpdateDescriptionDialogRestService } from './update-description-dialog-rest.service';

describe('UpdateDescriptionDialogRestService', () => {
  let service: UpdateDescriptionDialogRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateDescriptionDialogRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
