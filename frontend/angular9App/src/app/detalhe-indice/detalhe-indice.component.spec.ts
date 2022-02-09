import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalheIndiceComponent } from './detalhe-indice.component';

describe('DetalheIndiceComponent', () => {
  let component: DetalheIndiceComponent;
  let fixture: ComponentFixture<DetalheIndiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetalheIndiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalheIndiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
