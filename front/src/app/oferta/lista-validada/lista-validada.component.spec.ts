import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaValidadaComponent } from './lista-validada.component';

describe('ListaValidadaComponent', () => {
  let component: ListaValidadaComponent;
  let fixture: ComponentFixture<ListaValidadaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaValidadaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaValidadaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
