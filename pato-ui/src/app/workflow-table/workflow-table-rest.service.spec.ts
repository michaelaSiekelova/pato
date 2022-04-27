import { TestBed } from '@angular/core/testing';

import { WorkflowTableRestService } from './workflow-table-rest.service';

describe('WorkflowTableRestService', () => {
  let service: WorkflowTableRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WorkflowTableRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
