import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentPreferenceComponent } from './student-preference.component';

describe('StudentPreferenceComponent', () => {
  let component: StudentPreferenceComponent;
  let fixture: ComponentFixture<StudentPreferenceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentPreferenceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentPreferenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
