import { TestBed } from '@angular/core/testing';

import { UsuarioGuardService } from './usuario-guard.service';

describe('AuthGuardService', () => {
  let service: UsuarioGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsuarioGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
