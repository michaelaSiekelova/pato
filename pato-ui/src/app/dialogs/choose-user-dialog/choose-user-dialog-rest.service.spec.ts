import { TestBed } from '@angular/core/testing';

import { ChooseUserDialogRestService } from './choose-user-dialog-rest.service';

describe('ChooseUserDialogRestService', () => {
  let service: ChooseUserDialogRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChooseUserDialogRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
