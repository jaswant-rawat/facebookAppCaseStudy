import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { DeletePostComponent } from './delete-post/delete-post.component';
import { LoginComponent } from './login/login.component';
import { MarketplaceComponent } from './marketplace/marketplace.component';
import { PostsComponent } from './posts/posts.component';
import { SignupComponent } from './signup/signup.component';
import { UpdatePostComponent } from './update-post/update-post.component';

const routes: Routes = [

  {
        path:'',
        redirectTo:'login',
        pathMatch:'full'
  },
  {
    component:SignupComponent,
    path:'signup'
  },
  {
    component:LoginComponent,
    path:'login'
  },
  {
    component:PostsComponent,
    path:'posts'
  },
  {
    component:MarketplaceComponent,
    path:'marketplace'
  },
  {
    component:AboutComponent,
    path:'about'
  },
  {
    component:ContactComponent,
    path:'contact'
  },
  {
    component:CreatePostComponent,
    path:'create-post'
  },
  {
    component:UpdatePostComponent,
    path:'update-post'
  },
  {
    component:DeletePostComponent,
    path:'delete-post'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
