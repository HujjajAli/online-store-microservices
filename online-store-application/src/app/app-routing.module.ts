import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { MyProductsComponent } from './components/my-products/my-products.component';
import { CategoryProductsComponent } from './components/category-products/category-products.component';
import { AddProductComponent } from './components/add-product/add-product.component';
import { SingleProductComponent } from './components/single-product/single-product.component';

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
  },
  {
    path:'category-products',
    component:CategoryProductsComponent

  },
  {
    path:'add-product',
    component:AddProductComponent

  },
  {
    path:'product',
    component:SingleProductComponent

  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
