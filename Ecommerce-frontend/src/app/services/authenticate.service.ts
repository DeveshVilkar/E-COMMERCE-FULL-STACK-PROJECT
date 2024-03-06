import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {
  // for user for turning login button to logout
  private isAuthenticatedSubject=new BehaviorSubject<boolean>(false);
  isAutheticated$:Observable<boolean>=this.isAuthenticatedSubject.asObservable()

  // for admin for turning login button to logout
  private isAdminAuthenticatedSubject=new BehaviorSubject<boolean>(false);
  isAdminAutheticated$:Observable<boolean>=this.isAdminAuthenticatedSubject.asObservable();

  constructor() { }

  setAuthenticationState(result:boolean){
    this.isAuthenticatedSubject.next(result)
  }

  setAdminAuthenticationState(result:boolean){
     this.isAdminAuthenticatedSubject.next(result)
  }
}
