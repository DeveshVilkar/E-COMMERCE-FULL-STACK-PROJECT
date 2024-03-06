import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CategoryService } from '../services/category.service';

@Component({
  selector: 'app-saveproduct',
  templateUrl: './saveproduct.component.html',
  styleUrl: './saveproduct.component.css'
})
export class SaveproductComponent implements OnInit{

  productform!:FormGroup
  
  categorylist:Array<any>=[]

  constructor(private productservice:ProductService,
    private router:Router,
    private categoryservice:CategoryService,
    private fb:FormBuilder){
      this.productform=this.fb.group({
        name:'',
        imageurl:'',
        price:null,
        description:'',
        category_id:null
      })
    }

  ngOnInit(): void {
    this.categoryservice.listCategory().subscribe(data=>{     
      this.categorylist=data;
      console.log(this.categorylist, 'category')
    })
  }

  onselectCategory(event:any){
      this.productform.get('category_id')?.setValue(event.value)
  }

  addProduct(){
    if(this.productform.valid){
      const produ=this.productform.value
       console.log(produ)
       this.productservice.saveProduct(produ).subscribe({
        next:(value:any)=>{
            alert("product added")
            this.router.navigate(['home'])

        },error:(err:any)=>{
          alert("cancelled")
        },
       })
    }
    
  }

}
