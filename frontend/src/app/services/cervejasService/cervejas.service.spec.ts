import { TestBed } from '@angular/core/testing';

import { CervejasService } from './cervejas.service';

describe('CervejasService', () => {
  let service: CervejasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CervejasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
