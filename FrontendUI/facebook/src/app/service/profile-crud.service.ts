import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


const baseUrl='http://localhost:8081/api/v1/createProfile';
@Injectable({
  providedIn: 'root'
})
export class ProfileCrudService {


  
  constructor(private http:HttpClient) { }


  create(data:any):Observable<any>
  {                                               
    return this.http.post(baseUrl,data);
  }
}
