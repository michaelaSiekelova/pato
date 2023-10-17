import { TestBed } from '@angular/core/testing';

import { CreateUserDialogRestService } from './create-user-dialog-rest.service';

describe('CreateUserDialogRestService', () => {
  let service: CreateUserDialogRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateUserDialogRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
