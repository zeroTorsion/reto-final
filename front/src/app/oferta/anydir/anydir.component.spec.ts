import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnydirComponent } from './anydir.component';

describe('AnydirComponent', () => {
  let component: AnydirComponent;
  let fixture: ComponentFixture<AnydirComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnydirComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnydirComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
