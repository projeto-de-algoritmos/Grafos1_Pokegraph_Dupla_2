import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalWinnerComponent } from './modal-winner.component';

describe('ModalWinnerComponent', () => {
  let component: ModalWinnerComponent;
  let fixture: ComponentFixture<ModalWinnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalWinnerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalWinnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
