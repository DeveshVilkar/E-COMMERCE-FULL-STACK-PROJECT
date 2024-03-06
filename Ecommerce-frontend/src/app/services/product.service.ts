import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpclient:HttpClient) { }

  private baseurl="http://localhost:8080/product";

  listProduct():Observable<any>{
    return this.httpclient.get(`${this.baseurl}`)
  }

  saveProduct(product:Product):Observable<any>{
    return this.httpclient.post(`${this.baseurl}`,product)
  }

  getProductById(id:number):Observable<any>{
    return this.httpclient.get(`${this.baseurl}/${id}`)

  }

  
}
