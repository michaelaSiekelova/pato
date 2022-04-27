import { TestBed } from '@angular/core/testing';

import { CommentsTableRestService } from './comments-table-rest.service';

describe('CommentsTableRestService', () => {
  let service: CommentsTableRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CommentsTableRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
