import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


const baseUrl='http://localhost:8083/api2/v1/createPost';
const baseUrl2='http://localhost:8083/api2/v1/updatePost';
const baseUrl3='http://localhost:8083/api2/v1/deletePost';
@Injectable({
  providedIn: 'root'
})
export class PostCrudService {
  constructor(private http:HttpClient) { }

  create(data:any):Observable<any>
  {                                                 
    return this.http.post(baseUrl,data);
  }


  updatePost(id:any,data:any)
  {
     return this.http.put(`${baseUrl2}/${id}`,data);    
  }


  deletePost(id:any):Observable<any>
  {                                                
    return this.http.delete(`${baseUrl3}/${id}`);
  }

}
