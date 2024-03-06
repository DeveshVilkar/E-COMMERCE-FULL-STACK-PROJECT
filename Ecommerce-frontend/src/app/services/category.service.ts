import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private httpclient:HttpClient) { }

  private baseurl="http://localhost:8080/category"

  listCategory():Observable<any>{
    return this.httpclient.get(`${this.baseurl}`)
  }
}
