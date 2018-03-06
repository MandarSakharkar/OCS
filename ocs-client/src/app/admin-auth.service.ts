import { Injectable } from '@angular/core';
import { CanActivate,RouterStateSnapshot, ActivatedRouteSnapshot,Router} from "@angular/router";
@Injectable()
export class AdminAuthService implements CanActivate{

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(localStorage.getItem('adminLoginId')==undefined)
    {
      this.router.navigate(['admin-login']);
      return false;
    }
    else
    {
      return true;
    }
  }
  constructor(private router:Router) { }

}
