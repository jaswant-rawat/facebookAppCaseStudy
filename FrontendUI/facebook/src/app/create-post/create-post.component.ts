import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Post } from '../model/post';
import { PostCrudService } from '../service/post-crud.service';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {


  postObj:Post=new Post();
  constructor(private postService:PostCrudService,private router:Router) { }

  ngOnInit(): void {
  }


  savePost()
  {
    this.postService.create(this.postObj).subscribe(data=>
      {
        console.log(data);
        
      },
      error=>console.log(error));
  }

  goPostList()
  {
         this.router.navigate(['/posts']);
  }
  onSubmit()
  {
        console.log(this.postObj);
        this.savePost();
        this.goPostList();
        window.confirm("successfully added a new post");                     

        
  }

}
