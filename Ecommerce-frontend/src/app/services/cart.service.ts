import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Addcart } from '../addcart';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private baseurl="http://localhost:8080/cart/add"
  private geturl="http://localhost:8080/cart/"

  constructor(private http:HttpClient) { }

  addToCart(cart:Addcart,token:string):Observable<any>{
    return this.http.post(`${this.baseurl}?token=${token}`,cart)
  }

  getCartItems(token:string):Observable<any>{
      return this.http.get(`${this.geturl}?token=${token}`)
  }

  deleteItem(id:number,token:string):Observable<any>{
    return this.http.delete(`${this.geturl}${id}?token=${token}`)
  }
}
