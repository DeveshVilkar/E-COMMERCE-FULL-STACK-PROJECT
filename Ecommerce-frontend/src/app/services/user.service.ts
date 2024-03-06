import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Admin } from '../admin';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseurl="http://localhost:8080/user"
  private loginurl="http://localhost:8080/user/login"
  

  constructor(private httpclient:HttpClient) { }

  saveUser(user:User):Observable<Object>{
    return this.httpclient.post<Object>(`${this.baseurl}`,user)
  }

  loginUser(user:User):Observable<Object>{
    return this.httpclient.post<any>(`${this.loginurl}`,user)
  }

  getAllUser():Observable<any>{
    return this.httpclient.get(`${this.baseurl}`)
  }

}
