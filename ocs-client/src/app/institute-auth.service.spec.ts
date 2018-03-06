import { TestBed, inject } from '@angular/core/testing';

import { InstituteAuthService } from './institute-auth.service';

describe('InstituteAuthService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [InstituteAuthService]
    });
  });

  it('should be created', inject([InstituteAuthService], (service: InstituteAuthService) => {
    expect(service).toBeTruthy();
  }));
});
