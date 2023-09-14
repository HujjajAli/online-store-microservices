import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { MyProductsComponent } from './components/my-products/my-products.component';

const routes: Routes = [
  {
    path:'',
    redirectTo:'home',
    pathMatch:'full'
  },
  {
    path:'home',
    component:HomeComponent,
    data:{title:'Online Store Application'}
  },
  {
    path:'contactus',
    component:ContactUsComponent,
    data:{title:'Contact Us'}
  }
  ,
  {
    path:'about',
    component:AboutUsComponent,
    data:{title:'About Us'}
  },
  {
    path:'my-products',
    component:MyProductsComponent,
    data:{title:'My Products'}
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
