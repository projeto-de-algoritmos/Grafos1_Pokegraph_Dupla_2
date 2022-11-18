import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokemonSelectComponent } from './pokemon-select.component';

describe('PokemonSelectComponent', () => {
  let component: PokemonSelectComponent;
  let fixture: ComponentFixture<PokemonSelectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PokemonSelectComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PokemonSelectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
