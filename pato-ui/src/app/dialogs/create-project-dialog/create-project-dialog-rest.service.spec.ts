import { TestBed } from '@angular/core/testing';

import { CreateProjectDialogRestService } from './create-project-dialog-rest.service';

describe('CreateProjectDialogRestService', () => {
  let service: CreateProjectDialogRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateProjectDialogRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
