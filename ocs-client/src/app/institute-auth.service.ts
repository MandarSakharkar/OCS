import { Injectable } from '@angular/core';
import { CanActivate,Router,ActivatedRouteSnapshot,RouterStateSnapshot } from "@angular/router";
@Injectable()
export class InstituteAuthService implements CanActivate{

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(localStorage.getItem('instituteId')==undefined)
    {
      this.router.navigate(['institute-login']);
      return false;
    }
    else
    {
      return true;
    }
  }

  constructor(private router:Router) { }

}
