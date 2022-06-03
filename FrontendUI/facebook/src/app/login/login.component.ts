import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormGroup } from '@angular/forms';
import {  Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

public loginForm !: FormGroup;
 

  constructor(private formBuilder : FormBuilder,private http:HttpClient,private router:Router) { }


  ngOnInit(): void {

    this.loginForm=this.formBuilder.group(
      {
        mobile:[''],
        name:['']
        
         })
  }

  login(){
    this.http.get<any>("http://localhost:8081/api/v1/allProfiles")
    .subscribe(res=>{
       const user=res.find((a:any)=>{
         return a.mobile===this.loginForm.value.mobile && a.name===this.loginForm.value.name
       });
       if(user){
         alert("Login Success");
         this.loginForm.reset();
         this.router.navigate(['posts'])
       }else{
         alert("user not found");
       }
    },err=>{
      alert("something went wrong!!")
    })


  }

}
