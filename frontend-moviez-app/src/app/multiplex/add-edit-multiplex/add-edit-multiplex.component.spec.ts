import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditMultiplexComponent } from './add-edit-multiplex.component';

describe('AddEditMultiplexComponent', () => {
  let component: AddEditMultiplexComponent;
  let fixture: ComponentFixture<AddEditMultiplexComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddEditMultiplexComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditMultiplexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
