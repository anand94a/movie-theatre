import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MultiplexViewComponent } from './multiplex-view.component';

describe('MultiplexViewComponent', () => {
  let component: MultiplexViewComponent;
  let fixture: ComponentFixture<MultiplexViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MultiplexViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MultiplexViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
