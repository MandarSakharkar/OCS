import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentAllocationComponent } from './student-allocation.component';

describe('StudentAllocationComponent', () => {
  let component: StudentAllocationComponent;
  let fixture: ComponentFixture<StudentAllocationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentAllocationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentAllocationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
