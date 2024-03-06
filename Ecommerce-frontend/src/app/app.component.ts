import { Component, OnDestroy, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { RegisterUserComponent } from './register-user/register-user.component';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'Ecommerce-frontend';

  constructor(private route:ActivatedRoute){}

  ngOnInit(){
   
  }
  
  
}
