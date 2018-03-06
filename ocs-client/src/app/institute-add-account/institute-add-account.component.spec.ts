import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InstituteAddAccountComponent } from './institute-add-account.component';

describe('InstituteAddAccountComponent', () => {
  let component: InstituteAddAccountComponent;
  let fixture: ComponentFixture<InstituteAddAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InstituteAddAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InstituteAddAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
