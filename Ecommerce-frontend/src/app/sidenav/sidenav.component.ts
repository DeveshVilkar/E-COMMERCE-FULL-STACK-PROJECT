import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ProductService } from '../services/product.service';
import { Product } from '../product';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrl: './sidenav.component.css'
})
export class SidenavComponent implements OnInit{
  @Output() filteredList1:EventEmitter<Product[]>=new EventEmitter<Product[]>
  @Output() filteredlist2:EventEmitter<Product[]>=new EventEmitter<Product[]>
  
  product1:Product[]=[]

  ngOnInit(): void {
    
  }
  constructor(private productservice:ProductService ){}

  clicked(){
    this.productservice.listProduct().subscribe(data=>{
      const filter:Product[]=[]
      data.forEach((e:any) => {
        if (e.price<7501) {
          filter.push(e);            
        }
      });
      this.filteredList1.emit(filter) 
    }) 
  }

  clicked1(){
    this.productservice.listProduct().subscribe(data=>{
      const filter1:Product[]=[]
      data.forEach((e:any) => {
        if(e.price>7500 && e.price<13001){
          filter1.push(e)
        }
      });
      this.filteredlist2.emit(filter1);
    })  
  }

}
