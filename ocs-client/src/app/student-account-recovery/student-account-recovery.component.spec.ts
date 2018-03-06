import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentAccountRecoveryComponent } from './student-account-recovery.component';

describe('StudentAccountRecoveryComponent', () => {
  let component: StudentAccountRecoveryComponent;
  let fixture: ComponentFixture<StudentAccountRecoveryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentAccountRecoveryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentAccountRecoveryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
