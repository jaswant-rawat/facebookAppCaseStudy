import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Post } from '../model/post';
import { PostCrudService } from '../service/post-crud.service';

@Component({
  selector: 'app-delete-post',
  templateUrl: './delete-post.component.html',
  styleUrls: ['./delete-post.component.css']
})
export class DeletePostComponent implements OnInit {

  postObj:Post=new Post();            
  
  constructor(private postService:PostCrudService,private router:Router) { }      
  ngOnInit(): void {
  }

  onSubmit()
  {
        this.deletePost();                                   
        this.goPostList();
        window.confirm("successfully deleted");                    

  }

  deletePost()
  {
    this.postService.deletePost(this.postObj.id).subscribe(data=>
      {                                                                       
        console.log(data);
        
      },
      error=>console.log(error));
  }
  goPostList() 
  {
         this.router.navigate(['/posts']);                              //5
  }




}
