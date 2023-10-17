import { TestBed } from '@angular/core/testing';

import { TasksTableRestService } from './tasks-table-rest.service';

describe('TasksTableRestService', () => {
  let service: TasksTableRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TasksTableRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
