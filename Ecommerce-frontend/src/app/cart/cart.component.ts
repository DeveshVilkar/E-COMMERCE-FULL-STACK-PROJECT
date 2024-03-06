import { Component, OnInit, ViewChild } from '@angular/core';
import { ProductListComponent } from '../product-list/product-list.component'; 
import { CartService } from '../services/cart.service';
import { Cartitems } from '../cartitems';
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.css'
})
export class CartComponent implements OnInit {
  // allData: any;

  cartitems:Cartitems[]=[]
  totalcost!:number
  updatedcost!:number
  quantityoption:number[]=[1,2,3,4,5,6,7,8,9,10]
  
  constructor(private cartservice:CartService){}
  ngOnInit(){
    let gettoken=localStorage.getItem("token")
    // console.log(gettoken)
    if(gettoken!=null){
      this.cartservice.getCartItems(gettoken).subscribe(data=>{
        const res=data.cartItemDtos
        const cost=data.totalcost
        console.log(res)
        console.log(cost)
       this.cartitems=res;
       this.totalcost=cost;
      })
    }
  
  }
  deleteItem(cartitems:{id:number}){
      let id=cartitems.id;
      let deltoken=localStorage.getItem("token");
      if(deltoken!=null){
        this.cartservice.deleteItem(id,deltoken).subscribe(data=>{
          console.log(data);
        })
      }   
  }
  updateQuantity(event:number){
    console.log(event);   
    this.updatedcost=this.totalcost*event;
    console.log(this.updatedcost);
    
  }
}
