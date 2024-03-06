import { Component, Input, OnInit, SimpleChanges } from '@angular/core';
import { ProductService } from '../services/product.service';
import { Product } from '../product';
import { MatCardModule } from '@angular/material/card';
import { Router } from '@angular/router';
import { CartService } from '../services/cart.service';
import { Addcart } from '../addcart';


@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent implements OnInit {

  @Input() products1:Product[]=[]
  @Input() product2:Product[]=[]
  
  // displayColumn:string[]=['id','name','imageurl','price','description'];
  productdetail:Product[]=[]
  // creating addtocart instance
  cart:Addcart=new Addcart();
 
  constructor(private productservice:ProductService,
    private router:Router,
    private cartservice:CartService){}  

  ngOnInit(){
 
  }

  ngOnChanges(changes: SimpleChanges) {
    switch(true){
      case (changes['products1'] && changes['products1'].currentValue.length > 0):
        this.productdetail = this.products1;
        break;
      case (changes['product2'] && changes['product2'].currentValue.length>0):
        this.productdetail=this.product2;
        break;
      default:
        this.getUserList();
        break;

    }
    // if (changes['products1'] && changes['products1'].currentValue.length > 0) {
    //   this.productdetail = this.products1;
    // } else if(changes['product2'] && changes['product2'].currentValue.length>0) {
    //    this.productdetail=this.product2;     
    // }else{
    //   this.getUserList();
    // }
  }

  getUserList(){ 
    this.productservice.listProduct().subscribe({
      next:(res:any)=>{
        console.log(res,'oo7')
        this.productdetail=res;
      },
      error:(err:any)=>{
        console.log(err);
      }
    })

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
        alert("Added To Cart")
    })
    }
  }
  

}
