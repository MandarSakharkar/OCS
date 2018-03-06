import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InstituteValidateStudentComponent } from './institute-validate-student.component';

describe('InstituteValidateStudentComponent', () => {
  let component: InstituteValidateStudentComponent;
  let fixture: ComponentFixture<InstituteValidateStudentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InstituteValidateStudentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InstituteValidateStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
