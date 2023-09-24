import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardCervejasComponent } from './card-cervejas.component';

describe('CardCervejasComponent', () => {
  let component: CardCervejasComponent;
  let fixture: ComponentFixture<CardCervejasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardCervejasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardCervejasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
