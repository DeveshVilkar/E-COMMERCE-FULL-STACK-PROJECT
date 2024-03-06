import { ChangeDetectorRef, Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { RegisterUserComponent } from '../register-user/register-user.component';
import { Router } from '@angular/router';
import { AuthenticateService } from '../services/authenticate.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css',
})
export class HeaderComponent implements OnInit {
  token!: string;
  addprod!: string;

  constructor(
    private dialog: MatDialog,
    private router: Router,
    public authservice: AuthenticateService
  ) {}

  ngOnInit() {
    this.authservice.isAutheticated$.subscribe((result)=>{
      if(result){
        this.updationAterLogin()
      }
    })
  }
  updationAterLogin(){
    const t=localStorage.getItem("token");
    let admint=localStorage.getItem("admintoken");
    if(t!=null){
      this.token=t;
    }
    if(admint!=null){
       this.token=admint;
       this.addprod="aaaa";
    }

  }

  viewRegisterForm() {
    this.dialog.open(RegisterUserComponent);
  }

  home() {
    this.router.navigate(['/home']);
  }

  addProduct() {
    this.router.navigate(['/saveproduct']);
  }
  
  loginbutton() {
    this.router.navigate(['/loginuser']);
  }

  addtocart() {
    this.router.navigate(['/cart']);
  }

  logoutbutton() {
    localStorage.clear();
    this.authservice.setAuthenticationState(false);
    this.authservice.setAdminAuthenticationState(false);
  }
}
