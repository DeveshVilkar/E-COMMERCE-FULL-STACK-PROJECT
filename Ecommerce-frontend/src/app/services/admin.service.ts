import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from '../admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private adminlogin="http://localhost:8080/admin/login"

  constructor(private httpclient:HttpClient) { }

  adminLogin(admin:Admin):Observable<any>{
    return this.httpclient.post<any>(`${this.adminlogin}`,admin)
  }
}
