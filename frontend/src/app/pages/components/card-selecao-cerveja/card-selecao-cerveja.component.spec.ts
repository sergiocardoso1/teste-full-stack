import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardSelecaoCervejaComponent } from './card-selecao-cerveja.component';

describe('CardSelecaoCervejaComponent', () => {
  let component: CardSelecaoCervejaComponent;
  let fixture: ComponentFixture<CardSelecaoCervejaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardSelecaoCervejaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardSelecaoCervejaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
