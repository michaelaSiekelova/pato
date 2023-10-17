import { TestBed } from '@angular/core/testing';

import { CreateTaskDialogRestService } from './create-task-dialog-rest.service';

describe('CreateTaskDialogRestService', () => {
  let service: CreateTaskDialogRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateTaskDialogRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
