import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-forget',
  templateUrl: './forget.component.html',
  styleUrl: './forget.component.css'
})
export class ForgetComponent implements OnInit {
  emails:String[]=[]
  mailid:string=''

  constructor(private userservice:UserService){}

  ngOnInit(): void {
    this.userservice.getAllUser().subscribe(data=>{
      console.log(data)
      this.emails=data.map((e:any)=>e.email);
    })
  }

  sendOtp(){
    console.log("clicked")
    console.log(this.mailid)
    console.log(this.emails)
    this.emails.forEach(e => {
      if(e==this.mailid){
        alert('Otp send')
       }else{
        alert('user not found register first')
       }
    });
  
  }
}
