import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InstituteAllocationComponent } from './institute-allocation.component';

describe('InstituteAllocationComponent', () => {
  let component: InstituteAllocationComponent;
  let fixture: ComponentFixture<InstituteAllocationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InstituteAllocationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InstituteAllocationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
