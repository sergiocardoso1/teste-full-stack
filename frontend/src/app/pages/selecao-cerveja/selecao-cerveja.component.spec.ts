import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelecaoCervejaComponent } from './selecao-cerveja.component';

describe('SelecaoCervejaComponent', () => {
  let component: SelecaoCervejaComponent;
  let fixture: ComponentFixture<SelecaoCervejaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SelecaoCervejaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SelecaoCervejaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
