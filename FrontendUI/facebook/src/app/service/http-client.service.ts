import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

export class Post {
  constructor(


  public id:number,
	public name:string,
	public title:string,
	public  desc:string,
  ) {
  }
}

// This is a service class
@Injectable({
  providedIn: 'root'
})

export class HttpClientService{

  constructor(
    private httpClient: HttpClient
  ) { }

  getPosts(){
      console.log('Test Call');
      return this.httpClient.get<Post[]>('http://localhost:8081/api2/v1/allPosts');
  }
}