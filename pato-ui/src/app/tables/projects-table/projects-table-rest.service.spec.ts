import { TestBed } from '@angular/core/testing';

import { ProjectsTableRestService } from './projects-table-rest.service';

describe('ProjectsTableRestService', () => {
  let service: ProjectsTableRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProjectsTableRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
