import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllottedMoviesToMultiplexComponent } from './allotted-movies-to-multiplex.component';

describe('AllottedMoviesToMUltiplexComponent', () => {
  let component: AllottedMoviesToMultiplexComponent;
  let fixture: ComponentFixture<AllottedMoviesToMultiplexComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllottedMoviesToMultiplexComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllottedMoviesToMultiplexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
