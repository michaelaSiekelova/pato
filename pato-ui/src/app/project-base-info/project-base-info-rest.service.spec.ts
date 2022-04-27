import { TestBed } from '@angular/core/testing';

import { ProjectBaseInfoRestService } from './project-base-info-rest.service';

describe('ProjectBaseInfoRestService', () => {
  let service: ProjectBaseInfoRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProjectBaseInfoRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
