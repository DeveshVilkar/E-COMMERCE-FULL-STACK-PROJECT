import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { Addcart } from '../addcart';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{
  filteredproduct1:Product[]=[]
  filteredproduct2:Product[]=[]

  cart:Addcart=new Addcart();

  constructor(private cartservice:CartService){}
  ngOnInit(): void {
    
  }
 
  onFilterPoductList1(filteredproduct1:Product[]){
    console.log(filteredproduct1, 'filterdata')
    this.filteredproduct1=filteredproduct1;
  }

  onFilterProductList2(filteredproduct2:Product[]){
    console.log(filteredproduct2)
    this.filteredproduct2=filteredproduct2;
  }

  addprocart(product:{id:number}){
    // console.log(product.id)
    const idd=product.id;   
    this.cart.setProduct_id(idd);
    const receivedtoken=localStorage.getItem("token")
    this.cart.setQuantity(1);
    if(receivedtoken!=null){
      this.cartservice.addToCart(this.cart,receivedtoken).subscribe(res=>{
        console.log(res)
    })
    }
  }

}
