import { TestBed } from '@angular/core/testing';

import { GantChartRestService } from './gant-chart-rest.service';

describe('GantChartRestService', () => {
  let service: GantChartRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GantChartRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
