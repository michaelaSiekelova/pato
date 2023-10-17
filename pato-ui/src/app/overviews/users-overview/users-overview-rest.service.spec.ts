import { TestBed } from '@angular/core/testing';
import { KeycloakService } from 'keycloak-angular';

import { UsersOverviewRestService } from './users-overview-rest.service';

describe('UsersOverviewRestService', () => {
  let service: UsersOverviewRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [KeycloakService]
    });
    service = TestBed.inject(UsersOverviewRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
