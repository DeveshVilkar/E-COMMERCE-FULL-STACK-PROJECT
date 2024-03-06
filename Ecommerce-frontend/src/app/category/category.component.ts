import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategoryService } from '../services/category.service';
import { subscribe } from 'diagnostics_channel';
import { Category } from '../category'; 

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrl: './category.component.css'
})
export class CategoryComponent implements OnInit{

  listcategory:Category[]=[]
  
  constructor(private router:Router,
    private categoryservice:CategoryService){}

  ngOnInit(){
    this.categoryservice.listCategory().subscribe(data=>{
      this.listcategory=data;
    })
  }
  
  

}
