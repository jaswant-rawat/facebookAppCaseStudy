import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Post } from '../model/post';
import { PostCrudService } from '../service/post-crud.service';

@Component({
  selector: 'app-update-post',
  templateUrl: './update-post.component.html',
  styleUrls: ['./update-post.component.css']
})
export class UpdatePostComponent implements OnInit {

  postObj:Post=new Post();
  constructor(private postService:PostCrudService,private router:Router) { }
  ngOnInit(): void {
  }


  updatePost()
  {
    this.postService.updatePost(this.postObj.id,this.postObj).subscribe(data=>
      {
        console.log(data);                                  //3
        
      },
      error=>console.log(error));
  }

  goPostList()
  {
         this.router.navigate(['/posts']);                 //4
  }
  onSubmit()
  {
    console.log(this.postObj);
    this.updatePost();
   this.goPostList();      
   window.confirm("successfully updated");                      //5
  }

}
