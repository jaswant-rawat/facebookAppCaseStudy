import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder } from '@angular/forms';
import {  Router } from '@angular/router';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {


  public signupForm !: FormGroup;

  constructor(private formBuilder : FormBuilder, private http:HttpClient,private router:Router) { }

  ngOnInit(): void {
    this.signupForm=this.formBuilder.group(
       {
         id:[''],
         name:[''],
         mobile:[''],
        location:[''], 
     })
  }

  signUp(){
    this.http.post<any>("http://localhost:8082/api/v1/createProfile",this.signupForm.value)
    .subscribe(res=>{
      alert("Signup Successful");
      console.log(res);
      this.signupForm.reset();
      this.router.navigate(['posts']);
    },err=>{
      alert("Something went wrong")
    })
     
  }

}
