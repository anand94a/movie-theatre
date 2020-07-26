import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieMultiplexAllotmentComponent } from './movie-multiplex-allotment.component';

describe('MovieMultiplexAllotmentComponent', () => {
  let component: MovieMultiplexAllotmentComponent;
  let fixture: ComponentFixture<MovieMultiplexAllotmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieMultiplexAllotmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieMultiplexAllotmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
