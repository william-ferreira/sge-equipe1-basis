import { TestBed } from '@angular/core/testing';

import { VisitanteGuardService } from './visitante-guard.service';

describe('VisitanteGuardService', () => {
  let service: VisitanteGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VisitanteGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
