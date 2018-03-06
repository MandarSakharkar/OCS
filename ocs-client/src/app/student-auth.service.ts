import { Injectable } from '@angular/core';
import { CanActivate,ActivatedRouteSnapshot,RouterStateSnapshot,Router } from "@angular/router";
@Injectable()
export class StudentAuthService implements CanActivate{

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(localStorage.getItem('formNumber')==undefined)
    {
      this.router.navigate(['student-login']);
      return false;
    }
    else
    {
      return true;
    }
  }

  constructor(private router:Router) { }

}
