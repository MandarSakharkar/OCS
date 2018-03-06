import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InstituteLoginComponent } from './institute-login.component';

describe('InstituteLoginComponent', () => {
  let component: InstituteLoginComponent;
  let fixture: ComponentFixture<InstituteLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InstituteLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InstituteLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
