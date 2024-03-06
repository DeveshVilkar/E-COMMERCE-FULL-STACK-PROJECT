import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from '../services/user.service';
import { error } from 'console';
import { Router } from '@angular/router';
import { AdminService } from '../services/admin.service';
import { AuthenticateService } from '../services/authenticate.service';
import { MatDialog } from '@angular/material/dialog';
import { ForgetComponent } from '../forget/forget.component';


@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrl: './login-user.component.css'
})
export class LoginUserComponent implements OnInit{

  userloginform!:FormGroup
  constructor(private fb:FormBuilder,
    private userservice:UserService,
    private router:Router,
    private adminservice:AdminService,
    private authenticate:AuthenticateService,
    private dialog:MatDialog){
      this.userloginform=this.fb.group({
        email:'',
        password:'',
        isadmin:[false]
      })
    }

    ngOnInit(): void {
      
    }

    loginUser(){
      const checkadmin=this.userloginform.get('isadmin')?.value;
      console.log(checkadmin)
      if(checkadmin==false){
        if(this.userloginform.valid){
          const login=this.userloginform.value
            this.userservice.loginUser(login).subscribe({
              next:(response:any)=>{
                console.log(response)
                if(response.status_code==202){
                 let selecttoken=response.token.token
                 console.log(selecttoken)
                  localStorage.setItem("token",selecttoken)
                  this.authenticate.setAuthenticationState(true)
                  this.router.navigate(['/home'])
                }else{
                  alert("login failed")
                }
              },
              error:(error:any)=>{
                alert("login failed")
              }
            })
        }
      }else{
        const login=this.userloginform.value
         this.adminservice.adminLogin(login).subscribe({
            next:(response:any)=>{
              console.log(response)
               if(response.status_code==202){
                  let gottoken=response.adminToken.token
                  localStorage.setItem("admintoken",gottoken)
                  this.authenticate.setAdminAuthenticationState(true)
                  this.router.navigate(['/home'])
               }else{
                alert("login failed")
               }
            }
         })
      }        
    }
    openEmailDialog(){
      this.dialog.open(ForgetComponent,{
        width:'250px',
        height:'200px'
      })
    }
 }
