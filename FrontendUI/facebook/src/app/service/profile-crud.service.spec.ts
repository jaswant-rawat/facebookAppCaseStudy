import { TestBed } from '@angular/core/testing';

import { ProfileCrudService } from './profile-crud.service';

describe('ProfileCrudService', () => {
  let service: ProfileCrudService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProfileCrudService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
