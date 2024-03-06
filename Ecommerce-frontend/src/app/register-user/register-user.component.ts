import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from '../services/user.service';
import { MatDialog } from '@angular/material/dialog';
import { DialogRef } from '@angular/cdk/dialog';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrl: './register-user.component.css'
})
export class RegisterUserComponent implements OnInit{

  userForm!:FormGroup

  ngOnInit(): void {
    
  }

  constructor(private fb:FormBuilder,
    private userservice:UserService,
    private dialogue:DialogRef){
    this.userForm=this.fb.group({
      firstname:'',
      lastname:'',
      email:'',
      password:''
    })
  }

  addUser(){
    if(this.userForm.valid){
      const userdata=this.userForm.value;
      console.log(userdata)
      this.userservice.saveUser(userdata).subscribe({
       next:(val:any)=>{
        alert("user is added")
        this.dialogue.close();
       },
        error:(err:any)=>{
          console.log(err);
        },
      });
    }
  }
}
