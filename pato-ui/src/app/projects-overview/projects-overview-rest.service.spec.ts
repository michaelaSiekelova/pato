import { TestBed } from '@angular/core/testing';

import { ProjectsOverviewRestService } from './projects-overview-rest.service';

describe('ProjectsOverviewRestService', () => {
  let service: ProjectsOverviewRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProjectsOverviewRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
